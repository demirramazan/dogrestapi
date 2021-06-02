package com.udacity.dogrestapi.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.execption.DogNotFoundException;
import com.udacity.dogrestapi.execption.DogNotFoundGraphqlException;
import com.udacity.dogrestapi.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final DogRepository dogRepository;

    public List<String> findDogBreeds() {
        return dogRepository.getDogBreeds();
    }

    public String findDogBreedById(Long id) {
        return dogRepository.getDogBreedsById(id)
                .orElseThrow(() -> new DogNotFoundGraphqlException("Dog Not Found", id));
    }

    public Dog findDogsById(Long id) {
        return dogRepository.findById(id)
                .orElseThrow(() -> new DogNotFoundGraphqlException("Dog Not Found", id));
    }

    public List<String> findAllDogNames() {
        return dogRepository.getDogNames();
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }
}
