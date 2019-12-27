package com.lfallon.microservices.sfgbrewery.web.controller;

import com.lfallon.microservices.sfgbrewery.service.BeerService;
import com.lfallon.microservices.sfgbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {

        BeerDto savedBeer = beerService.saveBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        //TODO dynamically append hostname to url/location
        httpHeaders.add("location", "api/v1/beer" + savedBeer.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    public ResponseEntity handlePut(@RequestBody BeerDto beerDto, @PathVariable("beerId") UUID beerId) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
    }
}