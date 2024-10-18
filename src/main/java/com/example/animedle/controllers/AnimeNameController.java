package com.example.animedle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.animedle.services.CheckNameService;

@RestController
public class AnimeNameController {

    private final CheckNameService checkNameService;

    @Autowired
    public AnimeNameController(CheckNameService checkNameService) {
        this.checkNameService = checkNameService;
    }

    @PostMapping("/hello")
    public ResponseEntity<String> any(@RequestBody String body) {
        return ResponseEntity.ok(body);
    }
}
