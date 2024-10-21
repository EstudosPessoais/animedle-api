package com.example.animedle.factories;

import com.example.animedle.entities.anime.Chosen;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class MakeChosen {

    public static Chosen makeChosenFactory(
            UUID animeId,
            String chosenAnimeDate
    ) {
        return Chosen.builder()
                .id(UUID.randomUUID())
                .chosenAnimeId(Optional.ofNullable(animeId).orElse(UUID.randomUUID()))
                .chosenDate(Optional.ofNullable(chosenAnimeDate).orElse(LocalDate.now().toString()))
                .build();
    }
}
