package org.example.jpaonetomanyf25b.repository;

import jakarta.transaction.Transactional;
import org.example.jpaonetomanyf25b.model.Kommune;
import org.example.jpaonetomanyf25b.model.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegionRepositoryTest {

    @Autowired
    RegionRepository regionRepository;

    @Test
    void test5Resionger() {
        assertEquals(9, regionRepository.findAll().size());
    }

    @Test
    void testRegionNordjylland() {
        Optional<Region> region = regionRepository.findById("1081");
        assertTrue(region.isPresent());

    }

    @Test
    @Transactional
    void testAntalKommuneriRegionNordjylland() {
        Optional<Region> region = regionRepository.findById("1081");
        assertTrue(region.isPresent());
        List<Kommune> kommuner = region.get().getKommuner();
        assertEquals(11, kommuner.size());
    }

}