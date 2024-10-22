package com.example.animedle.services;

import com.example.animedle.entities.models.Genres;
import com.example.animedle.factories.MakeAnime;
import com.example.animedle.repositories.InMemoryAnimeRepository;
import com.example.animedle.repositories.InMemoryChosenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;



public class ChooseAnimeTest {

    private InMemoryAnimeRepository inMemoryAnimeRepository;
    private InMemoryChosenRepository inMemoryChosenRepository;
    private ChooseAnime sut;

    @BeforeEach
    void setup() {
        inMemoryAnimeRepository = new InMemoryAnimeRepository();
        inMemoryChosenRepository = new InMemoryChosenRepository();
        sut = new ChooseAnime(inMemoryChosenRepository, inMemoryAnimeRepository);
    }

    @Test
    @Description("When checking if the anime is the chosen one of the day, it should return success.")
    void whenChooseAnime_shouldReturnSuccess() throws Exception {
        // ARRANGE
        inMemoryAnimeRepository.db.add(MakeAnime.makeAnimeFactory(
                "Naruto", List.of(Genres.ACTION, Genres.ADVENTURE), null, null, null, null, null, null));
        inMemoryAnimeRepository.db.add(MakeAnime.makeAnimeFactory(
                "Sword Art Online", List.of(Genres.ACTION, Genres.ROMANCE), null, null, null, null, null, null));

        UUID animeId = inMemoryAnimeRepository.db.getFirst().getId();
        // ACT
        sut.execute();

        // ASSERT
        assertEquals(1, inMemoryChosenRepository.db.size());
    }
}
