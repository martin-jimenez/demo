package com.cities.city.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cities.city.entity.City;

import reactor.core.publisher.Flux;


@Repository
public interface CityRepository extends ReactiveMongoRepository<City, String>{

	Flux<City> findByName(String name);

	@Query("{'name':{ '$regex': '?0', '$options': 'i'}}")
	Flux<City> findByNameLike(String name, Sort sort);

	@Query("{'name': '?0', 'lat': '?1', 'long': '?2'}")
	Flux<City> FindBy(String name, String lat, String longitude, Sort sort);
}