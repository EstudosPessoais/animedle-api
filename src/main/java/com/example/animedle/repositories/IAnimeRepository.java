package com.example.animedle.repositories;

import com.example.animedle.entities.anime.Anime;

import java.util.List;

public interface IAnimeRepository {
    public List<Anime> findAllAnimes();
}
