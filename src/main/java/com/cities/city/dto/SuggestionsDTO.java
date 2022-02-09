package com.cities.city.dto;

import java.util.List;

import lombok.Data;


@Data
public class SuggestionsDTO {
	List<CityDTO> suggestion;
}
