package com.example.docker.service.impl;

import com.example.docker.entity.City;
import com.example.docker.repository.CityRepository;
import com.example.docker.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public Flux<City> save(City city) {
        return Flux.just(cityRepository.save(city));
    }

    @Override
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Flux<City> findById(Integer id) {
        return Flux.just(cityRepository.findById(id).get());
    }
}
