package com.example.docker.route;

import com.example.docker.handler.CityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CityRouteConfigure {
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(CityHandler handler) {
        return RouterFunctions.route(
                RequestPredicates.POST("/saveCity")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::saveCity)
                .andRoute(RequestPredicates.GET("/deleteCity")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::deleteCity)
                .andRoute(RequestPredicates.GET("/updateCity")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::updateCity)
                .andRoute(RequestPredicates.GET("/getCityById")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::getCityById);
    }
}
