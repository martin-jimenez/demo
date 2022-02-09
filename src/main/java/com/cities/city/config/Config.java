package com.cities.city.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebFlux
@Slf4j
@EnableReactiveMongoRepositories("com.cities.city.repository")
public class Config {

}
