package com.cities.city.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cities.city.dto.CityDTO;
import com.cities.city.service.CityService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;


@RestController
@AllArgsConstructor
@RequestMapping("/cities")
@Slf4j
public class CityController {
	private CityService cityService;

	@GetMapping("/suggestion")
	public Flux<CityDTO> getCity(@RequestParam(value="q", required = true) String name, @RequestParam(value="latitude", required=false, defaultValue = "") String latitude, @RequestParam(value="longitude", required=false, defaultValue = "") String longitude){
		if(!latitude.isEmpty() && !longitude.isEmpty())
			return cityService.getCity(name, latitude, longitude);
		else
			return cityService.getCity(name);
	}

}
