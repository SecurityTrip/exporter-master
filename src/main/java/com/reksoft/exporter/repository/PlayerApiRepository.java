package com.reksoft.exporter.repository;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PlayerApiRepository implements PlayerRepository {
    private static final Logger logger = LoggerFactory.getLogger(PlayerApiRepository.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApiProperties apiProperties;

    public List<PlayerViewDto> getPlayers() {
        logger.info("Attempting to get players list from API");
        String url = apiProperties.getBaseUrl() + "/api/Players";

        try {
            ResponseEntity<List<PlayerViewDto>> response = restTemplate.exchange(
                    url,
                    GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );

            logger.info("Successfully retrieved {} players", response.getBody() != null ? response.getBody().size() : 0);
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error while getting players from API. URL: {}", url, e);
            throw e;
        }
    }

    public List<PlayerViewDto> getFilteredPlayers(String filter) {
        logger.info("Attempting to get filtered players with filter: '{}'", filter);
        String uri = UriComponentsBuilder.fromHttpUrl(apiProperties.getBaseUrl() + "/api/Players/filter")
                .queryParam("filter", filter)
                .toUriString();

        try {
            ResponseEntity<List<PlayerViewDto>> response = restTemplate.exchange(
                    uri,
                    GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );

            logger.info("Successfully retrieved {} filtered players", response.getBody() != null ? response.getBody().size() : 0);
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error while getting filtered players from API. URL: {}, filter: {}", uri, filter, e);
            throw e;
        }
    }
}
