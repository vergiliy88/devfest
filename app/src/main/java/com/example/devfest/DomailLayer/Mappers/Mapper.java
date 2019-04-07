package com.example.devfest.DomailLayer.Mappers;

public interface Mapper<E, T> {
    T transform(E object);
}
