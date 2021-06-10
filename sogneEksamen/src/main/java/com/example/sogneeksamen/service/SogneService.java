package com.example.sogneeksamen.service;

import com.example.sogneeksamen.model.Sogne;
import com.example.sogneeksamen.repository.SogneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SogneService {

    @Autowired
    SogneRepository sogneRepository;

    public Set<Sogne> findAll(){
        Set<Sogne> sogneSet = new HashSet<>();
        for (Sogne sogne:sogneRepository.findAll()){
            sogneSet.add(sogne);
        }
        return sogneSet;
    }

    public Sogne findById(int id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (!optionalSogne.isPresent()) {
            throw new RuntimeException("Sogne " + id + " not found");
        }
        //return indholdet af optionalBrand
        return optionalSogne.get();
    }

    public Sogne create(Sogne sogne){
        return sogneRepository.save(sogne);
    }

    public Sogne update(Sogne sogne){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return sogneRepository.save(sogne);
    }

    public void deleteById(int id){

        sogneRepository.deleteById(id);
    }


}

