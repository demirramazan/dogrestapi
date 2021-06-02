package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();

    List<String> retrieveDogBreed();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();

    Dog updateDogName(Long id, String name);

    Dog deleteDogBreed(Long id);
}
