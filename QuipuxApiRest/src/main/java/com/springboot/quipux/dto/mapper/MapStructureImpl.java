package com.springboot.quipux.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.quipux.dto.PlayListDTO;
import com.springboot.quipux.dto.SongDTO;
import com.springboot.quipux.entity.PlayList;
import com.springboot.quipux.entity.Song;

@Component
public class MapStructureImpl implements MapStructure {

	@Override
	public PlayListDTO playListToPlayListDto(PlayList playList) {
		if (playList == null) {
			return null;
		}

		PlayListDTO dto = new PlayListDTO();
		dto.setId(playList.getId());
		dto.setNombre(playList.getNombre());
		dto.setDescripcion(playList.getDescripcion());
		dto.setCanciones(songSetToSongDtoSet(playList.getCanciones()));
		return dto;
	}

	@Override
	public SongDTO songToSongDto(Song song) {
		if(song ==null) {
			return null;
		}
		
		SongDTO dto = new SongDTO();
		dto.setSid(song.getSid());
		dto.setTitulo(song.getTitulo());
		dto.setArtista(song.getArtista());
		dto.setAlbum(song.getAlbum());
		dto.setAnno(song.getAnno());
		return dto;
	}

	
	@Override
	public PlayList playListDtoToPlayList(PlayListDTO playListDto) {
		if(playListDto ==null) {
			return null;
		}
		PlayList playList = new PlayList();
		playList.setId(playListDto.getId());
		playList.setNombre(playListDto.getNombre());
		playList.setDescripcion(playListDto.getDescripcion());
		playList.setCanciones(songSetDtoToSongSet(playListDto.getCanciones()));
		return playList;
	}

	@Override
	public Song songDtoToSong(SongDTO song) {
		if(song ==null) {
			return null;
		}
		
		Song dto = new Song();
		dto.setSid(song.getSid());
		dto.setTitulo(song.getTitulo());
		dto.setArtista(song.getArtista());
		dto.setAlbum(song.getAlbum());
		dto.setAnno(song.getAnno());
		return dto;
	}

	protected List<SongDTO> songSetToSongDtoSet(List<Song> set) {
		if (set == null) {
			return null;
		}
		List<SongDTO> set1 = new ArrayList<>();
		for (Song song : set) {
			set1.add(songToSongDto(song));

		}

		return set1;

	}
	
	protected List<Song> songSetDtoToSongSet(List<SongDTO> set) {
		if (set == null) {
			return null;
		}
		List<Song> set1 = new ArrayList<>();
		for (SongDTO song : set) {
			set1.add(songDtoToSong(song));

		}

		return set1;

	}
	

}
