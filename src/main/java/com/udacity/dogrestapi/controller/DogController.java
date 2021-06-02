package com.udacity.dogrestapi.controller;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }
    @GetMapping
    public ResponseEntity<List<Dog>> getDogs() {
        return new ResponseEntity<>(dogService.retrieveDogs(), HttpStatus.OK);
    }
    @GetMapping("/breeds")
    public ResponseEntity<List<String>> getDogBreeds() {
        return new ResponseEntity<>(dogService.retrieveDogBreed(), HttpStatus.OK);
    }
    @GetMapping("/breeds/{id}")
    public ResponseEntity<String> getDogBreedsById(@PathVariable Long id) {
        return new ResponseEntity<>(dogService.retrieveDogBreedById(id), HttpStatus.OK);
    }
    @GetMapping("/names")
    public ResponseEntity<List<String>> getDogNames() {
        return new ResponseEntity<>(dogService.retrieveDogBreed(), HttpStatus.OK);
    }
}
