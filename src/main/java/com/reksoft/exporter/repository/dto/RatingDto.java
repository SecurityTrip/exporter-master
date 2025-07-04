package com.reksoft.exporter.repository.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class RatingDto {
    private Integer id;
    private Integer score;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private ZonedDateTime atMoment;
    private Integer teamId;
    private TeamDto team;
}