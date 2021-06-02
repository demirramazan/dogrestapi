package com.udacity.dogrestapi.repository;

import com.udacity.dogrestapi.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DogRepository extends JpaRepository<Dog, Long> {

    @Query("select breed from Dog")
    List<String> getDogBreeds();

    @Query("select breed from Dog where id=:id")
    Optional<String> getDogBreedsById(@Param("id") Long id);

    @Query("select name from Dog")
    List<String> getDogNames();

}
