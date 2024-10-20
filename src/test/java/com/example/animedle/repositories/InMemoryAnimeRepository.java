package com.example.animedle.repositories;

import com.example.animedle.entities.anime.Anime;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAnimeRepository implements IAnimeRepository {
    public List<Anime> db = new ArrayList<>();


    @Override
    public List<Anime> findAllAnimes() {
        return db;
    }
}
