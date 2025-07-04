package com.reksoft.exporter.service;

import com.opencsv.CSVWriter;
import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class TeamCsvReportService {

    @Autowired
    private TeamService teamService;

//    public File generateReport(String filePath) throws IOException {
//        List<Team> teams = teamService.getTeams();
//
//        File file = new File(filePath);
//        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
//            String[] header = {"ID", "Team Name", "Players"};
//            writer.writeNext(header);
//
//            for (Team team : teams) {
//                String[] line = {
//                        String.valueOf(team.getId()),
//                        team.getName(),
//                        team.getPlayers()
//                };
//                writer.writeNext(line);
//            }
//        }
//
//        return file;
//    }
}
