package com.example.animedle.repositories;

import com.example.animedle.entities.anime.Anime;
import com.example.animedle.entities.anime.Chosen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class InMemoryChosenRepository implements IChosenRepository{

    public List<Chosen> db = new ArrayList<>();


    @Override
    public Chosen getAnimeOfTheDay(UUID animeId) {
        Optional<Chosen> animeChosen = db.stream().filter(item ->
            item.getChosenAnimeId().equals(animeId) &&
            item.getChosenDate().equals(LocalDate.now().toString())
        ).findFirst();

        return animeChosen.orElse(null);

    }
}
