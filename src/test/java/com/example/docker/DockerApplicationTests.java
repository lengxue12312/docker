package com.example.docker;

import com.example.docker.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DockerApplicationTests {

    @Autowired
    private CityRepository cityRepository;
    @Test
    void contextLoads() {
        System.out.println(cityRepository.findById(1));
    }
}
