package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Artist;
import com.project.services.ArtistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/artists")
public class ArtistController {

	@Autowired
    private ArtistService artistService;
	

    @GetMapping("/{artistId}")
    public Mono<String> getArtistById(@PathVariable String artistId) {
        return artistService.getArtistById(artistId);
    }

    @GetMapping
    public Flux<Artist> getAllArtists() {
        return artistService.getAllArtists()
                .flatMapMany(response -> {
                    List<Artist> artists = parseArtists(response);
                    return Flux.fromIterable(artists);
                });
    }

    private List<Artist> parseArtists(String response) {
        return List.of();
    }
}