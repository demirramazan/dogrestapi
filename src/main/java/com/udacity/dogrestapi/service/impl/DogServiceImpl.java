package com.udacity.dogrestapi.service.impl;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.execption.DogNotFoundException;
import com.udacity.dogrestapi.repository.DogRepository;
import com.udacity.dogrestapi.service.DogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<Dog> retrieveDogs() {
        return dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        return dogRepository.getDogBreeds();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        return dogRepository.getDogBreedsById(id).orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.getDogNames();
    }

    @Override
    public Dog updateDogName(Long id, String name) {
        Dog dog = dogRepository.getById(id);
        dog.setName(name);
        return dogRepository.save(dog);
    }

    @Override
    public Dog deleteDogBreed(Long id) {
        Dog dog = dogRepository.getById(id);
        dog.setBreed("");
        return dogRepository.save(dog);
    }
}
