package org.example.jpaonetomanyf25b.service;

import org.example.jpaonetomanyf25b.model.Kommune;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiServiceGetKommunerImplTest {

    @Autowired
    ApiServiceGetKommuner serviceKommuner;

    @DisplayName("TestStartsMed")
    @ParameterizedTest
    @MethodSource("kommunedatastartswith")
    void testStartsWithParm(char c, int cnt) {
        List<Kommune> lstKom = serviceKommuner.getKommunerStartsWith(c);
        assertEquals(cnt, lstKom.size());
    }

    public static Object[][] kommunedatastartswith() {
        return new Object[][] {
                {"A", 6},
                {"B", 5},
                {"C", 1},
                {"D", 1}
        };
    }

}