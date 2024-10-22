package com.example.animedle.repositories;

import com.example.animedle.entities.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryAnimeRepository implements IAnimeRepository {

    public List<Anime> db = new ArrayList<>();

    @Override
    public List<Anime> findAllAnimes() {
        return db;
    }

    @Override
    public Anime findById(UUID animeId) {
         Optional<Anime> anime = db.stream()
                .filter(item -> item.getId().equals(animeId))
                .findFirst();

        return anime.orElse(null);

    }
}
