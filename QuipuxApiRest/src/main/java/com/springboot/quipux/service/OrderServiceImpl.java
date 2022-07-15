package com.springboot.quipux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.quipux.dto.PlayListDTO;
import com.springboot.quipux.dto.mapper.MapStructure;
import com.springboot.quipux.entity.PlayList;
import com.springboot.quipux.repository.PlayListRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private PlayListRepository listRepository;
	@Autowired
	private MapStructure mapStructure;

	@Override
	public List<PlayList> GetAllPlayListSong() {
		return listRepository.findAll();
	}

	@Override
	public PlayList save(PlayListDTO playListDto) {
		
		return listRepository.save(mapStructure.playListDtoToPlayList(playListDto));
	}

	@Override
	public Optional<PlayList> findById(int id) {
		
		return listRepository.findById(id);
	}

	@Override
	public List<PlayList> findByName(String nombre) {
		return listRepository.findAll();
		 
	}

	@Override
	public void delete(int id) {
		listRepository.deleteById(id);
		
	}

	@Override
	public PlayList findByNameToObject(String nombre) {
		return listRepository.findByNombre(nombre);
		
	}
	
	

}
