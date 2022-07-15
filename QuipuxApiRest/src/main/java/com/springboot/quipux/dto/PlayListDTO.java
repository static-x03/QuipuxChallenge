package com.springboot.quipux.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PlayListDTO {
	@JsonIgnore
	private int id;
	@ApiModelProperty(position = 0)
	@NotEmpty(message = "el campo no puede ser Nulo")
	private String nombre;
	@ApiModelProperty(position = 1)
	@NotEmpty(message = "el campo no puede ser Nulo")
	private String descripcion;
	@ApiModelProperty(position = 2)
	@NotEmpty(message = "el campo no puede ser Nulo")
	private List<SongDTO> canciones;
}
