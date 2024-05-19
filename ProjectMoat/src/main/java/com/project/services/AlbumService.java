package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Album;
import com.project.repositories.AlbumRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album updateAlbum(Long id, Album updatedAlbum) {
        Album existingAlbum = albumRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Album not found"));

        existingAlbum.setArtist(updatedAlbum.getArtist());
        existingAlbum.setAlbumName(updatedAlbum.getAlbumName());
        existingAlbum.setYear(updatedAlbum.getYear());

        return albumRepository.save(existingAlbum);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}