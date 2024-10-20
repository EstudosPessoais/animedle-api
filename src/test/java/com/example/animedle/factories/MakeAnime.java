package com.example.animedle.factories;

import com.example.animedle.entities.anime.Anime;
import com.example.animedle.entities.anime.models.Genres;
import com.example.animedle.entities.anime.models.Seasons;
import com.example.animedle.entities.anime.models.StatusAnime;
import jakarta.annotation.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MakeAnime {

    public static Anime makeAnimeFactory(
            String name,
            List<Genres> genresList,
            @Nullable Seasons season,
            @Nullable List<String> studio,
            @Nullable String producers,
            @Nullable Integer popularity,
            @Nullable String releaseYear,
            @Nullable StatusAnime status
    ) {
        return Anime.builder()
                .id(UUID.randomUUID())
                .name(name)
                .genresList(genresList)
                .season(Optional.ofNullable(season).orElse(Seasons.WINTER))
                .studio(Optional.ofNullable(studio).orElse(List.of("AnyCorp")))
                .producers(Optional.ofNullable(producers).orElse("AnyProducer"))
                .popularity(Optional.ofNullable(popularity).orElse(80))
                .releaseYear(Optional.ofNullable(releaseYear).orElse("2024"))
                .status(Optional.ofNullable(status).orElse(StatusAnime.FINISHED))
                .build();
    }
}
