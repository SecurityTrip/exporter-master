package com.reksoft.exporter.repository.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
public class MatchHistoryDto {
    private Integer id;
    private Integer winnerId;
    private Integer loserId;
    private Integer tournamentId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private ZonedDateTime date;
    private String winner;
    private String loser;
    private TournamentDto tournament;
}
