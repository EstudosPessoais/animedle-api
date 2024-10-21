package com.example.animedle.services;

import com.example.animedle.entities.anime.Anime;
import com.example.animedle.entities.anime.models.Genres;
import com.example.animedle.errors.ResourceNotFoundException;
import com.example.animedle.factories.MakeAnime;
import com.example.animedle.factories.MakeChosen;
import com.example.animedle.repositories.InMemoryAnimeRepository;
import com.example.animedle.repositories.InMemoryChosenRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CheckAnimeCorrectTest {

    private InMemoryAnimeRepository inMemoryAnimeRepository;
    private InMemoryChosenRepository inMemoryChosenRepository;
    private CheckAnimeCorrect sut;

    @BeforeEach
    void setup() {
        inMemoryAnimeRepository = new InMemoryAnimeRepository();
        inMemoryChosenRepository = new InMemoryChosenRepository();
        sut = new CheckAnimeCorrect(inMemoryChosenRepository, inMemoryAnimeRepository);
    }

    @Test
    void whenCheckTheAnimeOfTheDay_returnAnAnime() throws ResourceNotFoundException {
        // ARRANGE
        inMemoryAnimeRepository.db.add(MakeAnime.makeAnimeFactory(
                "Naruto", List.of(Genres.ACTION, Genres.ADVENTURE), null, null, null, null, null, null));
        inMemoryAnimeRepository.db.add(MakeAnime.makeAnimeFactory(
                "Sword Art Online", List.of(Genres.ACTION, Genres.ROMANCE), null, null, null, null, null, null));

        UUID chosenAnimeId = inMemoryAnimeRepository.db.getFirst().getId();

        inMemoryChosenRepository.db.add(MakeChosen.makeChosenFactory(chosenAnimeId, LocalDate.now().toString()));

        // ACT
        Anime result = sut.execute(chosenAnimeId);

        // ASSERT
        Assertions.assertNotNull(result);
    }

    @Test
    void whenCheckTheAnimeOfTheDay_returnErrorBecauseDBAnimeIsEmpty() {
        // ASSERT
        UUID randomValue = UUID.randomUUID();
        inMemoryChosenRepository.db.add(MakeChosen.makeChosenFactory(randomValue, LocalDate.now().toString()));

        // ACT
        ResourceNotFoundException result = assertThrows(ResourceNotFoundException.class, () -> {
           sut.execute(randomValue);
        });

        // ARRANGE
        assertEquals("[Error] - Anime didn't found", result.getMessage());
    }

    @Test
    void whenCheckTheAnimeOfTheDay_returnErrorBecauseTodayIsAnotherAnime() {
        // ASSERT
        inMemoryAnimeRepository.db.add(MakeAnime.makeAnimeFactory(
                "Naruto", List.of(Genres.ACTION, Genres.ADVENTURE), null, null, null, null, null, null));
        inMemoryAnimeRepository.db.add(MakeAnime.makeAnimeFactory(
                "Sword Art Online", List.of(Genres.ACTION, Genres.ROMANCE), null, null, null, null, null, null));

        UUID chosenAnimeId = inMemoryAnimeRepository.db.getFirst().getId();
        UUID wrongValue = UUID.randomUUID();

        inMemoryChosenRepository.db.add(MakeChosen.makeChosenFactory(chosenAnimeId, LocalDate.now().toString()));

        // ACT
        ResourceNotFoundException result = assertThrows(ResourceNotFoundException.class, () -> {
            sut.execute(wrongValue);
        });

        // ARRANGE
        assertEquals("[Error] - Today is not the day for this anime", result.getMessage());
    }
}
