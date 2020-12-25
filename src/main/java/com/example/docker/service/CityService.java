package com.example.docker.service;

import com.example.docker.entity.City;
import reactor.core.publisher.Flux;

public interface CityService {
    Flux<City> save(City city);
    void deleteById(Integer id);
    Flux<City> findById(Integer id);
}
