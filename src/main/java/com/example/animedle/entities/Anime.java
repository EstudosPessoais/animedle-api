package com.example.animedle.entities;

import com.example.animedle.core.RootEntity;
import com.example.animedle.entities.models.Genres;
import com.example.animedle.entities.models.Seasons;
import com.example.animedle.entities.models.StatusAnime;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Document(collection = "animes")
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
