package com.cviniciusdr.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(name="estilo")
	private String estilo;
	
	@NotNull
	@Column(name="temp_min")
	@JsonProperty("temperaturaMinima")
	private Double temperaturaMin;
	
	@NotNull
	@Column(name="temp_max")
	@JsonProperty("temperaturaMaxima")
	private Double temperaturaMax;
	
	@JsonIgnore
	public double getTemperaturaMedia() {
		return (temperaturaMax + temperaturaMin) / 2;
	}
	
	@JsonIgnore
	public double getDistancia(Double temperatura) {
		return Math.abs(getTemperaturaMedia() - temperatura);
		
	}

	public Cerveja() {
		
	}
	public Cerveja(String estilo, Double temperaturaMin, Double temperaturaMax) {
		this.estilo = estilo;
		this.temperaturaMin = temperaturaMin;
		this.temperaturaMax = temperaturaMax;
	}


}
