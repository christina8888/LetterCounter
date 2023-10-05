package com.example.lettercounter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LetterCounterApplicationTests {
    LetterCounterService letterCounterService;

    public LetterCounterApplicationTests(LetterCounterService letterCounterService) {
        this.letterCounterService = letterCounterService;
    }

    @Test
    public void testCountLetters_validString() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 2);
        expected.put('b', 1);
        expected.put('c', 1);
        expected.put('d', 1);
        expected.put('e', 1);

        Map<Character, Integer> actual = letterCounterService.countLetters("aabced");

        assertEquals(expected, actual);
    }

    @Test
    public void testCountLetters_validRussianString() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('а', 2);
        expected.put('б', 1);
        expected.put('в', 1);
        expected.put('г', 1);
        expected.put('д', 1);

        Map<Character, Integer> actual = letterCounterService.countLetters("аабвгде");

        assertEquals(expected, actual);
    }

    @Test
    public void testCountLetters_invalidString() {
        letterCounterService.countLetters("ABC123");
    }

    @Test
    public void testCountLetters_singleLetter() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> actual = letterCounterService.countLetters("a");

        assertEquals(expected, actual);
    }

    @Test
    public void testCountLetters_emptyString() {
        Map<Character, Integer> expected = new LinkedHashMap<>();

        Map<Character, Integer> actual = letterCounterService.countLetters("");

        assertEquals(expected, actual);
    }

}
