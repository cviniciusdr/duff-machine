package com.cviniciusdr.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PlaylistRequest {
	
	@NotNull
	@JsonProperty("temperature")
	private Double temperatura;
	

}
