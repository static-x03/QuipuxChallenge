package com.springboot.quipux.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.quipux.entity.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Integer>{
	PlayList findByNombre(String nombre);
	
}
