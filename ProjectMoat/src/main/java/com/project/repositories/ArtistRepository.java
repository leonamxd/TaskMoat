package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}