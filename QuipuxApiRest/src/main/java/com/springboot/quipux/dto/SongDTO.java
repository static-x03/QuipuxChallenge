package com.springboot.quipux.dto;




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
public class SongDTO {
	@JsonIgnore
	private int sid;
	@ApiModelProperty(position = 0)
	private String titulo;
	@ApiModelProperty(position = 1)
	private String artista;
	@ApiModelProperty(position = 2)
	private String album;
	@ApiModelProperty(position = 3)
	private String anno;
}
