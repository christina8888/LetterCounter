package com.example.lettercounter;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LetterCounterServiceImpl implements LetterCounterService {
    @Override
    public Map<Character, Integer> countLetters(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : str.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result.entrySet().stream()
        .sorted(Map.Entry.<Character, Integer> comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
