package com.udacity.dogrestapi.execption;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Dog not found")
public class DogNotFoundException extends RuntimeException{
    public DogNotFoundException() {
        super();
    }

    public DogNotFoundException(String message) {
        super(message);
    }
}
