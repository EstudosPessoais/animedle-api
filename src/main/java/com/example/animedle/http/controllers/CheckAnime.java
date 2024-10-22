package com.example.animedle.http.controllers;

import com.example.animedle.entities.Anime;
import com.example.animedle.repositories.IAnimeRepository;
import com.example.animedle.repositories.IChosenRepository;
import com.example.animedle.services.GetAllAnimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class CheckAnime {

    private final IAnimeRepository animeRepository;

    @Autowired
    private CheckAnime(IAnimeRepository animeRepository, IChosenRepository chosenRepository) {
        this.animeRepository = animeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Anime>> getAllAnimes() {
        GetAllAnimes getAllAnimes = new GetAllAnimes(animeRepository);
        List <Anime> animes = getAllAnimes.execute();
        return ResponseEntity.ok(animes);
    }
}
