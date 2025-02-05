package com.vaibhav25_mnnit.springcrud.service;


import com.vaibhav25_mnnit.springcrud.dao.AvengerRepository;
import com.vaibhav25_mnnit.springcrud.entity.Avenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvengerServiceImpl implements AvengerService {

    private AvengerRepository theAvengerRepository;

    @Autowired
    public AvengerServiceImpl(AvengerRepository theAvengerRepository){
        this.theAvengerRepository = theAvengerRepository;
    }

    @Override
    public List<Avenger> getAll() {
        List<Avenger> theAvengers = theAvengerRepository.findAll();
        System.out.println(theAvengers);
        return theAvengers;
    }

    @Override
    public Avenger getById(int id) {
        Optional<Avenger> res = theAvengerRepository.findById(id);
        Avenger theAvenger;
        if(res.isPresent())
        {
            theAvenger = res.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        System.out.println(theAvenger);
        return theAvenger;
    }

    @Override
    public void save(int id) {

    }

    @Override
    public void deleteById(int id) {

    }
}
