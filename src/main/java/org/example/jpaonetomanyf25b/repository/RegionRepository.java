package org.example.jpaonetomanyf25b.repository;

import org.example.jpaonetomanyf25b.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, String> {
    Optional<Region> findRegionByNavn(String navn);
}
