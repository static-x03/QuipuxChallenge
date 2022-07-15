package com.springboot.quipux.dto;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SongDTO {
	private int sid;
	private String titulo;
	private String artista;
	private String album;
	private String anno;
}
