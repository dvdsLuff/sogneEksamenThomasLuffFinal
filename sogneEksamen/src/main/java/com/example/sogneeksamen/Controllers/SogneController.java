package com.example.sogneeksamen.Controllers;

import com.example.sogneeksamen.model.Sogne;
import com.example.sogneeksamen.repository.KommuneRepository;
import com.example.sogneeksamen.repository.SogneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SogneController {

    @Autowired
    SogneRepository sogneRepository;

    @Autowired
    KommuneRepository kommuneRepository;

    public SogneController(SogneRepository sogneRepository) {
        this.sogneRepository = sogneRepository;
    }

    @GetMapping("/sogn")
    public ResponseEntity<List<Sogne>> findAll() {
        List<Sogne> carList = new ArrayList<>();
        for (Sogne sogne : sogneRepository.findAll()) {
            carList.add(sogne);
        }
        return ResponseEntity.status(HttpStatus.OK).body(carList);
    }

    @GetMapping("/sogn/{id}")
    public ResponseEntity<Optional<Sogne>> findById(@PathVariable int id) {
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (optionalSogne.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalSogne);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalSogne);
        }
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/sogn", consumes = "application/json")
    public ResponseEntity<Sogne> create(@RequestBody Sogne sogne) {
        Sogne newSogne = sogneRepository.save(sogne);

        return ResponseEntity.ok(newSogne);
    }

    //update
    @PutMapping("/sogn/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Sogne sogne) {
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (!optionalSogne.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'sogn " + id + " not found'}");
        }
        sogneRepository.save(sogne);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'updated' }");

    }

    //HTTP DELETE
    @DeleteMapping("/sogn/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<Sogne> optionalSogne = sogneRepository.findById(id);
        if (!optionalSogne.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'sogn " + id + " not found'}");
        }
        sogneRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'deleted' }");
    }

}
