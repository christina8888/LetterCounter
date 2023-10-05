package com.example.lettercounter;

import java.util.Map;

public interface LetterCounterService {
    public Map<Character, Integer> countLetters(String str);
}
