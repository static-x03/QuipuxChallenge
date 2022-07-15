package com.springboot.quipux.dto.mapper;

import org.mapstruct.Mapper;

import com.springboot.quipux.dto.PlayListDTO;
import com.springboot.quipux.dto.SongDTO;
import com.springboot.quipux.entity.PlayList;
import com.springboot.quipux.entity.Song;

@Mapper(
		componentModel = "spring"
		)
public interface MapStructure {
	PlayListDTO playListToPlayListDto(PlayList playList);
	SongDTO songToSongDto(Song song);
	PlayList playListDtoToPlayList(PlayListDTO playList);
	Song songDtoToSong(SongDTO song);
}
