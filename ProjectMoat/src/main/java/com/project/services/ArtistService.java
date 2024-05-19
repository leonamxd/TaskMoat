package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ArtistService {

    private final WebClient webClient;

    @Autowired
    public ArtistService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getAllArtists() {
        return webClient.get()
                .uri("/artists-api-controller")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getArtistById(String artistId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/artists-api-controller")
                        .queryParam("artist_id", artistId)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}