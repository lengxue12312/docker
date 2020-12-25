package com.example.docker.controller;

import com.example.docker.entity.City;
import com.example.docker.repository.CityRepository;
import com.example.docker.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class CityController {
//    @Autowired
//    private CityService cityService;
//    @GetMapping(value = "saveCity")
//    public String saveCity(String cityName, String cityIntroduce) {
//        City city = new City(cityName, cityIntroduce);
//        cityService.save(city);
//        return "success";
//    }
//    @GetMapping(value = "deleteCity")
//    public String deleteCity(int cityId) {
//        cityService.deleteById(cityId);
//        return "success";
//    }
//
//    @GetMapping(value = "updateCity")
//    public String updateCity(int cityId, String cityName, String cityIntroduce) {
//        City city = new City(cityId, cityName, cityIntroduce);
//        cityService.save(city);
//        return "success";
//    }
//
//    @GetMapping(value = "getCityById")
//    public City getCityById(int cityId) {
//        return cityService.findById(cityId);
//    }
}