package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}