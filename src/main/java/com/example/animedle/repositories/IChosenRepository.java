package com.example.animedle.repositories;

import com.example.animedle.entities.anime.Anime;
import com.example.animedle.entities.anime.Chosen;

import java.util.UUID;

public interface IChosenRepository {
    public Chosen getAnimeOfTheDay(UUID animeId);
}
