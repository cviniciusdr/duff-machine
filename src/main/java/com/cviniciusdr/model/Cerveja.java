package com.cviniciusdr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String estilo;
	
	@NotNull
	@JsonProperty("temperaturaMinima")
	private Double temperaturaMin;
	
	@NotNull
	@JsonProperty("temperaturaMaxima")
	private Double temperaturaMax;
	

}
