package com.example.sogneeksamen.service;

import com.example.sogneeksamen.model.Kommune;
import com.example.sogneeksamen.model.Sogne;
import com.example.sogneeksamen.repository.KommuneRepository;
import com.example.sogneeksamen.repository.SogneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class KommuneService {

    @Autowired
    KommuneRepository kommuneRepository;

    public Set<Kommune> findAll(){
        Set<Kommune> kommuneSet = new HashSet<>();
        for (Kommune kommune:kommuneRepository.findAll()){
            kommuneSet.add(kommune);
        }
        return kommuneSet;
    }

    public Kommune findById(int id){
        Optional<Kommune> optionalKommune = kommuneRepository.findById(id);
        if (!optionalKommune.isPresent()) {
            throw new RuntimeException("Kommune " + id + " not found");
        }
        return optionalKommune.get();
    }

    public Kommune create(Kommune kommune){
        return kommuneRepository.save(kommune);
    }

    public Kommune update(Kommune kommune){
        return kommuneRepository.save(kommune);
    }

    public void deleteById(int id){
        kommuneRepository.deleteById(id);
    }


}