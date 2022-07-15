package com.springboot.quipux.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.quipux.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{

}
