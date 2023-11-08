package com.eggur.task.controller;

import com.eggur.task.service.CharacterFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/task/")
public class CharacterFrequencyController {

    private final CharacterFrequencyService characterFrequencyService;

    @Autowired
    public CharacterFrequencyController(CharacterFrequencyService characterFrequencyService) {
        this.characterFrequencyService = characterFrequencyService;
    }

    @GetMapping(path = "/count")
    public Map<Character, Integer> getCharCount(@RequestParam("str") String str){
        return characterFrequencyService.getCount(str);
    }
}
