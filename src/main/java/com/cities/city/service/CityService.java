package com.cities.city.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.cities.city.dto.CityDTO;
import com.cities.city.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;


@Service
@Slf4j
public class CityService implements CityImp{
	private CityRepository cityRepository;

	CityService(CityRepository cityRepository){
		this.cityRepository = cityRepository;
	}


	@Override
	public  Flux<CityDTO> getCity(final String name){
		return cityRepository.findByNameLike("^" + name, Sort.by(Sort.Direction.DESC, "longitud")).flatMap(city -> {
			String string = city.getName() + "," + city.getAdmin1() + "," + city.getCountry();
			double score = ((Double.parseDouble(city.getLat()) + Double.parseDouble(city.getLongitud()))/90)*-1;
			String score2 = score + "";
			score2 = score2.substring(0, 3);
			CityDTO cityDTO = CityDTO.builder()
					.name(string)
					.score(score2)
					.latitud(city.getLat())
					.longitud(city.getLongitud())
					.build();
			return Flux.just( cityDTO ) ;

		});

	}



	@Override
	public Flux<CityDTO> getCity(final String name, final String latitud, final String longitude){
		return cityRepository.FindBy(name, latitud, longitude, Sort.by(Sort.Direction.DESC, "longitud")).flatMap(city -> {
			String string = city.getName() + "," + city.getAdmin1() + "," + city.getCountry();
			double score = ((Double.parseDouble(city.getLat()) + Double.parseDouble(city.getLongitud()))/90)*-1;
			String score2 = score + "";
			score2 = score2.substring(0, 3);
			return Flux.just(CityDTO.builder()
					.name(string)
					.score(score2)
					.latitud(city.getLat())
					.longitud(city.getLongitud())
					.build());
		});

	}


}
