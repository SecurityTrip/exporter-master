package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.TeamApiRepository;
import com.reksoft.exporter.repository.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamApiRepository teamApiRepository;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Team> getTeams() {
        List<TeamDto> teamDtos = teamApiRepository.getTeams();
        return teamDtos.stream().map(teamMapper::map).toList();
    }
}
