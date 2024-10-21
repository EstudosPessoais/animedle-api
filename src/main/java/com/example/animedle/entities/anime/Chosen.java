package com.example.animedle.entities.anime;


import com.example.animedle.core.RootEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
public class Chosen extends RootEntity {
    private UUID chosenAnimeId;
    private String chosenDate;

    public static Chosen create(UUID animeId) {
        return Chosen.builder()
                .id(UUID.randomUUID())
                .chosenAnimeId(animeId)
                .chosenDate(LocalDate.now().toString())
                .updatedAt(LocalDate.now())
                .createdAt(LocalDate.now())
                .build();
    }
}
