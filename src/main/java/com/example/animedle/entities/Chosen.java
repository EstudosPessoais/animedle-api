package com.example.animedle.entities;


import com.example.animedle.core.RootEntity;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Document(collection = "chosens")
public class Chosen extends RootEntity {
    private UUID chosenAnimeId;
    private String chosenDate;

    public Chosen(UUID chosenAnimeId, @Nullable String chosenDate) {
        this.chosenAnimeId = chosenAnimeId;
        this.chosenDate = Optional.ofNullable(chosenDate).orElse(LocalDate.now().toString());
    }
}
