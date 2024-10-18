package com.example.animedle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.animedle.services.CheckNameService;

import ch.qos.logback.core.util.StringUtil;

@RestController
public class AnimeNameController {

    private final CheckNameService checkNameService;

    @Autowired
    public AnimeNameController(CheckNameService checkNameService) {
        this.checkNameService = checkNameService;
    }

    @GetMapping("/anime-name")
    public ResponseEntity<String> any(@RequestParam String animeName) {
        try {
            String anime = checkNameService.execute(animeName);
            if (StringUtil.isNullOrEmpty(anime)) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(anime);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
