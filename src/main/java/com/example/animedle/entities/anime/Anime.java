package com.example.animedle.entities.anime;

import com.example.animedle.core.RootEntity;
import com.example.animedle.entities.anime.models.Genres;
import com.example.animedle.entities.anime.models.Seasons;
import com.example.animedle.entities.anime.models.StatusAnime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class Anime extends RootEntity {

    private String name;
    private List<Genres> genresList;
    private Seasons season;
    private List<String> studio;
    private String producers;
    private Integer popularity;
    private String releaseYear;
    private StatusAnime status;
}
