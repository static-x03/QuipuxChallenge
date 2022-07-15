package com.springboot.quipux.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PlayListDTO {
	private int id;
	@NotEmpty(message = "el campo no puede ser Nulo")
	private String nombre;
	@NotEmpty(message = "el campo no puede ser Nulo")
	private String descripcion;
	@NotEmpty(message = "el campo no puede ser Nulo")
	private List<SongDTO> songs;
}
