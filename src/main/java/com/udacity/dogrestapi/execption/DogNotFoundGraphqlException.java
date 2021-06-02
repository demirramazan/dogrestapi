package com.udacity.dogrestapi.execption;


import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundGraphqlException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundGraphqlException() {
        super();
    }

    public DogNotFoundGraphqlException(String message, Long id) {
        super(message);
        extensions.put("invalidDogId", id);
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
