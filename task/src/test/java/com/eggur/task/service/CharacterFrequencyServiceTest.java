package com.eggur.task.service;

import com.eggur.task.exception.InvalidStringException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CharacterFrequencyServiceTest {
    private final CharacterFrequencyService characterFrequencyService = new CharacterFrequencyService();

    //positive
    @Test
    void calculateSymbolsFrequency() {
        String test = "aabcccc";
        Map<Character,Integer> expected = new LinkedHashMap<>();
        expected.put('c',4);
        expected.put('a',2);
        expected.put('b',1);
        Map<Character,Integer> provided = characterFrequencyService.getCount(test);
        assertThat(expected).isEqualTo(provided);
    }

    //negative
    @Test
    void calculateSymbolsFrequencyEmptyString() {
        String test = "";
        assertThatThrownBy(() -> characterFrequencyService.getCount(test))
                .isInstanceOf(InvalidStringException.class)
                .hasMessageContaining(
                        "Empty string param!"
                );
    }

    @Test
    void calculateSymbolsFrequencyNullString() {
        assertThatThrownBy(() -> characterFrequencyService.getCount(null))
                .isInstanceOf(InvalidStringException.class)
                .hasMessageContaining(
                        "Empty string param!"
                );
    }
}