package com.reksoft.exporter.model;

import com.reksoft.exporter.repository.dto.PlayerDto;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Team {
    private Integer id;
    private String name;
    private List<PlayerDto> players;

    public String getPlayersString() {
        return players.stream()
                .map(player -> player.getName() + " " + player.getSurname())
                .collect(Collectors.joining(", "));
    }
}
