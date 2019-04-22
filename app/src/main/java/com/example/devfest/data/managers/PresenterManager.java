package com.example.devfest.data.managers;


import com.example.devfest.presentation.presenters.BasePresenter;

import java.util.HashMap;

public class PresenterManager<K, V extends BasePresenter> {
    private HashMap<K, V> map;

    public PresenterManager(){
        map = new HashMap<>();
    }

    public void add(K key, V value){
        map.put(key, value);
    }

    public V get(K key){
        if (map.containsKey(key))
            return map.get(key);
        return null;
    }
}
