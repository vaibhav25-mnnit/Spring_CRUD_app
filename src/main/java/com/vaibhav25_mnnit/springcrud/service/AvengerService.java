package com.vaibhav25_mnnit.springcrud.service;

import com.vaibhav25_mnnit.springcrud.entity.Avenger;

import java.util.List;

public interface AvengerService {

    List<Avenger> getAll();

    Avenger getById(int id);

    void save(Avenger theAvenger);

    void deleteById(int id);
}
