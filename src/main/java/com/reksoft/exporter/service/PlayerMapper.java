package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public Player map(PlayerViewDto playerViewDto) {
        Player player = new Player();
        player.setId(playerViewDto.getId());
        player.setCountry(playerViewDto.getCountry());
        player.setNickname(playerViewDto.getNickName());
        player.setFullName(playerViewDto.getCombinedName());
        player.setTeamName(playerViewDto.getTeamName());
        return player;
    }
}
