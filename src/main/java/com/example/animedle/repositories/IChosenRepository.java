package com.example.animedle.repositories;

import com.example.animedle.entities.Chosen;

import java.util.UUID;

// [] - TODO: Need to change Exception from create
public interface IChosenRepository {
    public Chosen create(Chosen chosenAnime) throws Exception;
    public Chosen getAnimeOfTheDay(UUID animeId);
}
