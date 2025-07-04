package com.reksoft.exporter.service;

import com.opencsv.CSVWriter;
import com.reksoft.exporter.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerCsvReportService {

    private final PlayerService playerService;

    private String combineName(String fullName, String nickname) {
        String[] parts = fullName.split("(?=\\p{Lu})");  // Разделение по любой заглавной букве (Unicode)
        return (parts.length > 1)
                ? parts[0] + " \"" + nickname + "\" " + String.join("", Arrays.copyOfRange(parts, 1, parts.length))
                : fullName + " \"" + nickname + "\"";
    }

    public File generateReport(String filePath) throws IOException {
        List<Player> players = playerService.getPlayers();

        File file = new File(filePath);
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            String[] header = {"ID", "Combined Name", "Nickname", "Country", "Team Name", "Full Name"};
            writer.writeNext(header);

            for (Player player : players) {
                String fullName = player.getFullName();
                String nickname = player.getNickname();
                String[] line = {
                        String.valueOf(player.getId()),
                        fullName,
                        nickname,
                        player.getCountry() != null ? String.valueOf(player.getCountry()) : "",
                        player.getTeamName(),
                        combineName(fullName, nickname)
                };
                writer.writeNext(line);
            }
        }

        return file;
    }
}
