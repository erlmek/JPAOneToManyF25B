package org.example.jpaonetomanyf25b.controller;

import org.example.jpaonetomanyf25b.model.Region;
import org.example.jpaonetomanyf25b.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("regioner")
    public List<Region> getRegions(){
        return regionRepository.findAll();
    }

    @PostMapping("/region2")
    public ResponseEntity<String> postRegion2(@RequestParam String kode, @RequestParam String navn) {
        return ResponseEntity.ok("Received kode: " + kode + ", navn: " + navn);
    }

    @PostMapping("/region")
    public ResponseEntity<Region> postRegion(@RequestBody Region region) {
        Region savedRegion = regionRepository.save(region);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegion);
    }



}
