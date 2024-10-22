package com.example.animedle.http.controllers;

import com.example.animedle.entities.Anime;
import com.example.animedle.repositories.IAnimeRepository;
import com.example.animedle.repositories.IChosenRepository;
import com.example.animedle.services.CheckAnimeCorrect;
import com.example.animedle.services.GetAllAnimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/anime")
public class CheckAnime {

    private final IAnimeRepository animeRepository;
    private final IChosenRepository chosenRepository;

    @Autowired
    private CheckAnime(IAnimeRepository animeRepository, IChosenRepository chosenRepository) {
        this.animeRepository = animeRepository;
        this.chosenRepository = chosenRepository;
    }

    @GetMapping
    public ResponseEntity<List<Anime>> getAllAnimes() {
        GetAllAnimes getAllAnimes = new GetAllAnimes(animeRepository);
        List <Anime> animes = getAllAnimes.execute();
        return ResponseEntity.ok(animes);
    }

    @GetMapping
    @RequestMapping("/check/{id}")
    public ResponseEntity<Anime> CheckAnimeDay(@PathVariable("id") UUID id) {
        CheckAnimeCorrect checkAnimeCorrect = new CheckAnimeCorrect(chosenRepository, animeRepository);
        Anime anime = checkAnimeCorrect.execute(id);
        if(ObjectUtils.isEmpty(anime)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(anime);
    }
}
