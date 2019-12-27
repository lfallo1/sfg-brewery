package com.lfallon.microservices.sfgbrewery.service;

import com.lfallon.microservices.sfgbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getById(UUID beerId) {
        return BeerDto.builder().id(beerId)
                .beerName("Coors")
                .beerStyle("Light")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return beerDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Updating beer: " + beerId.toString());
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting beer: " + beerId.toString());
    }
}
