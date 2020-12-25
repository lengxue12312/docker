package com.example.docker.handler;

import com.alibaba.fastjson.JSON;
import com.example.docker.entity.City;
import com.example.docker.service.CityService;
import com.example.docker.util.HttpRes;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sun.security.jgss.HttpCaller;

import java.util.Map;
import java.util.Objects;

@Component
public class CityHandler {
    @Autowired
    private CityService cityService;

    public Mono<ServerResponse> saveCity(ServerRequest request){
        Map<String, String> queryParams = request.exchange().getRequest().getQueryParams().toSingleValueMap();
        City city = JSON.parseObject(JSON.toJSONString(queryParams), City.class);
        Flux<City> save = cityService.save(city);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(save, City.class);
    }

    public Mono<ServerResponse> deleteCity(ServerRequest request){
        Integer id = Integer.parseInt(Objects.requireNonNull(request.exchange().getRequest().getQueryParams().getFirst("id")));
        cityService.deleteById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Flux.just(new HttpRes("删除成功", 200)), Object.class);
    }

    public Mono<ServerResponse> updateCity(ServerRequest request){
        int id = Integer.parseInt(Objects.requireNonNull(request.exchange().getRequest().getQueryParams().getFirst("id")));
        String cityName = request.exchange().getRequest().getQueryParams().getFirst("cityName");
        String cityIntroduce = request.exchange().getRequest().getQueryParams().getFirst("cityIntroduce");
        Flux<City> save = cityService.save(new City(id, cityName, cityIntroduce));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(save, City.class);
    }

    public Mono<ServerResponse> getCityById(ServerRequest request){
        int id = Integer.parseInt(Objects.requireNonNull(request.exchange().getRequest().getQueryParams().getFirst("id")));
        Flux<City> byId = cityService.findById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(byId, City.class);
    }
}
