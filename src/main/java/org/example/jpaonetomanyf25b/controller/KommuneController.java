package org.example.jpaonetomanyf25b.controller;

import org.example.jpaonetomanyf25b.model.Kommune;
import org.example.jpaonetomanyf25b.model.Region;
import org.example.jpaonetomanyf25b.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class KommuneController {

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("kommuner")
    public List<Kommune> getKommuner(){
        return kommuneRepository.findAll();
    }

    @PostMapping("/kommune")
    public ResponseEntity<Kommune> postKommune(@RequestBody Kommune kommue) {
        Kommune savedKommune = kommuneRepository.save(kommue);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedKommune);
    }

    @DeleteMapping("/kommune/{kode}")
    public ResponseEntity<Void> deleteKommune(@PathVariable String kode) {
        if (!kommuneRepository.existsById(kode)) {
            return ResponseEntity.notFound().build();
        }
        kommuneRepository.deleteById(kode);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}

