package com.example.animedle.database.mongodb.configuration;

import com.example.animedle.entities.Anime;
import com.example.animedle.entities.models.Genres;
import com.example.animedle.entities.models.Seasons;
import com.example.animedle.entities.models.StatusAnime;

import java.util.List;

public class FactoryAnimeSeed {

    static Anime makeAnimeFactory(
            String name,
            List<Genres> genresList,
            Seasons season,
            List<String> studio,
            String producers,
            Integer popularity,
            String releaseYear,
            StatusAnime status
    ) {
        return Anime.builder()
                .name(name)
                .genresList(genresList)
                .season(season)
                .studio(studio)
                .producers(producers)
                .popularity(popularity)
                .releaseYear(releaseYear)
                .status(status)
                .build();
    }


    static List<Anime> seedAnimeDb() {
        return List.of(makeAnimeFactory(
                "Re:Zero kara Hajimeru Isekai Seikatsu 3rd Season",
                List.of(Genres.ADVENTURE, Genres.ACTION, Genres.DRAMA, Genres.FANTASY, Genres.SUPERNATURAL, Genres.ROMANCE),
                Seasons.FALL,
                List.of("White Fox"),
                "KADOKAWA",
                86,
                "2016",
                StatusAnime.RELEASING
            ),
        makeAnimeFactory(
                "Corpse Party: Tortured Souls - Bougyakusareta Tamashii no Jukyou",
                List.of(Genres.HORROR, Genres.MYSTERY, Genres.SUPERNATURAL),
                Seasons.SUMMER,
                List.of("Asread"),
                "MAGES.",
                58,
                "2013",
                StatusAnime.FINISHED
            )
        );
    }
}
