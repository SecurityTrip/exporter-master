package com.reksoft.exporter.repository.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class TournamentDto {
    private Integer id;
    private String name;
    private String organizer;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private ZonedDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private ZonedDateTime endDate;
    private List<TournamentParticipantInfoDto> teamParticipantInfos;
    private List<TournamentPrizeDto> tournamentPrizes;
}
