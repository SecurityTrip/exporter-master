package com.reksoft.exporter.repository;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.repository.dto.TeamDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class TeamApiRepository implements TeamRepository {
    private static final Logger log = LoggerFactory.getLogger(TeamApiRepository.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiProperties apiProperties;

    @Override
    public List<TeamDto> getTeams() {
        String url = apiProperties.getBaseUrl() + "/api/Teams";
        log.info("Making GET request to URL: {}", url);

        try {
            ResponseEntity<List<TeamDto>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );

            log.debug("Received response with status: {}", response.getStatusCode());
            if (log.isTraceEnabled()) {
                log.trace("Response headers: {}", response.getHeaders());
            }

            List<TeamDto> teams = response.getBody();
            log.info("Successfully retrieved {} teams", teams != null ? teams.size() : 0);

            return teams;

        } catch (RestClientException e) {
            log.error("Failed to retrieve teams from API. URL: {}", url, e);
            throw new RuntimeException("Failed to retrieve teams from API", e);
        }
    }
}