package com.wulghash.breweryclient.web.client;

import com.wulghash.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beer = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beer);
    }

    @Test
    void saveNewBeer() {
        BeerDto newBeer = BeerDto.builder().beerName("Alofa").build();

        URI uri = breweryClient.saveNewBeer(newBeer);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateBeer() {
        BeerDto updatedBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Rofl")
                .build();

        breweryClient.updateBeer(updatedBeer.getId(), updatedBeer);
    }
    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}