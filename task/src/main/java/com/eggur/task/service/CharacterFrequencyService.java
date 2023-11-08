package com.eggur.task.service;
import com.eggur.task.exception.InvalidStringException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CharacterFrequencyService {

    public Map<Character, Integer> getCount(String str){
        validate(str);
        Map<Character, Integer> charCount = new HashMap<>();
        for (char character : str.toCharArray()){
            charCount.put(character, charCount.getOrDefault(character, 0) + 1);
        }
        return mapSort(charCount);
    }

    private Map<Character, Integer> mapSort(Map<Character, Integer> map){
        return map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (entry1, entry2) -> entry1, LinkedHashMap::new));
    }

    private void validate(String str){
        if (str == null || str.isEmpty()){
            throw new InvalidStringException("Empty string param!");
        }
    }
}
