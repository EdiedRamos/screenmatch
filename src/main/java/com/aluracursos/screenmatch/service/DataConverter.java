package com.aluracursos.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements DataConverterI {

    private final ObjectMapper objectMapper;

    public DataConverter() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public <T> T getData(String json, Class<T> classConverter) {
        try {
            return objectMapper.readValue(json, classConverter);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
