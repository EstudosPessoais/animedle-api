package com.example.animedle.database.mongodb.configuration;

import com.example.animedle.entities.Chosen;

import java.time.LocalDate;
import java.util.UUID;

public class FactoryChosenSeed {

    static Chosen makeChosenFactory(
            UUID animeId
    ) {
        return Chosen.builder()
                .chosenAnimeId(animeId)
                .chosenDate(LocalDate.now().toString())
                .build();
    }

}
