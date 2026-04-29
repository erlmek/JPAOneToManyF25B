package org.example.jpaonetomanyf25b.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class KommuneTest {

    @Test
    void test() {
        fail("Det går slet ikke");
    }

    @Test
    void test2() {
        assertEquals("ABC", "ABC");
    }

    @Test
    void testDiv0() {
        int a = 10;
        int b = 0;
        int c = a / b;
        assertEquals(0, c);
    }

    @Test
    @DisplayName("Her er extra langt array")
    void testArr() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, ()-> "Array sort");
    }

    @DisplayName("paramtest med 3 arrays")
    @ParameterizedTest
    @MethodSource("sortnumbersArgument")
    void testArrParm(int[] numbers, int[] expected) {
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, () -> "der er fejl " + Arrays.toString(numbers) + " i array");
    }


    private static Stream<Arguments> sortnumbersArgument() {
        return Stream.of(
                Arguments.of(new int[]{12,3,4,1}, new int[]{1,3,4,12}),
                Arguments.of(new int[]{1,2,3,4}, new int[]{1,2,3,4}),
                Arguments.of(new int[]{-4,3,0,1234567}, new int[]{1,2,3,4})
        );

    }

}