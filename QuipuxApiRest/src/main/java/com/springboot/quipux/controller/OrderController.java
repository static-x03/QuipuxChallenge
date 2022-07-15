package com.springboot.quipux.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.quipux.dto.PlayListDTO;
import com.springboot.quipux.entity.PlayList;
import com.springboot.quipux.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;


	@PostMapping("/lists")
	public ResponseEntity<?> create(@Valid @RequestBody PlayListDTO dto) {

		try {
			if (dto == null) {
				return ResponseEntity.unprocessableEntity().build();
			}
			PlayList playList = service.save(dto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(playList.getId())
					.toUri();
			return ResponseEntity.created(uri).body(playList);
		} catch (DataIntegrityViolationException e) {
			Map<String, Object> body = new HashMap<>();

			body.put("timestamp", LocalDateTime.now());
			body.put("message", "EL nombre de la PlayList está repetido");

			return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/lists")
	public ResponseEntity<?> getAllPlayList() {
		List<PlayList> getAll = service.GetAllPlayListSong();
		return ResponseEntity.ok(getAll);
	}

	@GetMapping("/lists/{listName}")
	public ResponseEntity<?> getPlayListByName(@RequestParam String nombre) {
		//List<PlayList> getNamePlayList = service.findByName(nombre);
		PlayList object = service.findByNameToObject(nombre);
		if (object == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(object);

	}

	@DeleteMapping("/lists/{listName}")
	public ResponseEntity<?> deleteByName(@RequestParam String nombre) {
		PlayList listDelete = service.findByNameToObject(nombre);
		if (listDelete == null) {
			return ResponseEntity.notFound().build();
		}
		service.delete(listDelete.getId());
		return ResponseEntity.noContent().build();
	}

}
