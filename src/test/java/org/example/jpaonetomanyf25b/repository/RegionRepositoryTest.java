package org.example.jpaonetomanyf25b.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegionRepositoryTest {

    @Autowired
    RegionRepository regionRepository;

    @Test
    void test5Resionger() {
        assertEquals(9, regionRepository.findAll().size());
    }

}