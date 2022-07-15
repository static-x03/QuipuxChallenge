package com.springboot.quipux.service;

import java.util.List;
import java.util.Optional;

import com.springboot.quipux.dto.PlayListDTO;
import com.springboot.quipux.entity.PlayList;

public interface OrderService {

	public List<PlayList> GetAllPlayListSong();
	public PlayList save(PlayListDTO playListDto);
	public Optional<PlayList> findById(int id);
	List<PlayList> findByName(String nombre);
	PlayList findByNameToObject(String nombre);
	void delete(int id);
}
