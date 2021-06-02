package com.udacity.dogrestapi.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.execption.DogNotFoundException;
import com.udacity.dogrestapi.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private final DogRepository dogRepository;

    public Dog updateDogName(String newName, Long id) {
        Dog dog = dogRepository.findById(id)
                .orElseThrow(() -> new DogNotFoundException("Dog is not found", id));
        dog.setName(newName);
        return dogRepository.save(dog);
    }

    public boolean deleteDogBreed(Long id) {
        Dog dog = dogRepository.findById(id)
                .orElseThrow(() -> new DogNotFoundException("Dog is not found", id));
        dog.setBreed(null);
        dogRepository.save(dog);
        return true;
    }

}
