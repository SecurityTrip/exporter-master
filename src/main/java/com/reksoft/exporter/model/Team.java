package com.reksoft.exporter.model;

import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Team {
    private Integer id;
    private String name;
    private List<PlayerViewDto> players;

    public String getPlayersString() {
        return players.stream()
                .map(PlayerViewDto::getCombinedName)
                .collect(Collectors.joining(", "));
    }
}
