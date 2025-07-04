package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.dto.TeamDto;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {
    public Team map(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());
        team.setPlayers(teamDto.getPlayers());
        return team;
    }
}
