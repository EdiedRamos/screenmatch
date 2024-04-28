package com.aluracursos.screenmatch.service;

public interface DataConverterI {
    <T> T getData(String json, Class<T> classConverter);

}

