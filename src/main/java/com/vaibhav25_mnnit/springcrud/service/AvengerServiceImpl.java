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
        return theAvenger;
    }

    @Override
    public void save(Avenger theAvenger) {
        theAvengerRepository.save(theAvenger);
    }

    @Override
    public void deleteById(int id) {
        theAvengerRepository.deleteById(id);
    }
}
