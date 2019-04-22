package com.example.devfest.domain.mappers;

public interface Mapper<E, T> {
    T transform(E object);
}
