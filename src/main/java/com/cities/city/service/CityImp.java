package com.cities.city.service;

import com.cities.city.dto.CityDTO;
import reactor.core.publisher.Flux;


public interface CityImp {
	public  Flux<CityDTO> getCity(final String name);
	public Flux<CityDTO> getCity(final String name, final String latitud, final String longitude);
}