package dev.patika.gittigidiyorhomework02.service;

import java.util.List;

public interface BaseService<T>{

    //Base service signatures

    List<T> findAll();
    T findById(int id);
    T save(T object);
    void deleteById(int id);
    T update(T object);
}
