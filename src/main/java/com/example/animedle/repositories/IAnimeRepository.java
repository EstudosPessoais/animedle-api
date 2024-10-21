package com.example.animedle.repositories;

import com.example.animedle.entities.anime.Anime;

import java.util.List;
import java.util.UUID;

public interface IAnimeRepository {
    public List<Anime> findAllAnimes();
    public Anime findById(UUID animeId);
}
