package com.udacity.dogrestapi.controller;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Location microservice is running.")
})
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
        return new ResponseEntity<>(dogService.retrieveDogNames(), HttpStatus.OK);
    }
}
