package com.cities.city.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data @AllArgsConstructor  @NoArgsConstructor @Builder
public class CityDTO {
	private String name;
    private String latitud;
    private String longitud;
    private String score;
}
