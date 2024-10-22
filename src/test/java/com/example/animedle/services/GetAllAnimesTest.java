package com.example.animedle.services;

import com.example.animedle.entities.Anime;
import com.example.animedle.entities.models.Genres;
import com.example.animedle.errors.ResourceNotFoundException;
import com.example.animedle.factories.MakeAnime;
import com.example.animedle.repositories.InMemoryAnimeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GetAllAnimesTest {

    private InMemoryAnimeRepository inMemoryAnimeRepository;
    private GetAllAnimes sut;


    @BeforeEach
    void setup() {
        inMemoryAnimeRepository = new InMemoryAnimeRepository();
        sut = new GetAllAnimes(inMemoryAnimeRepository);
    }

    @Test
    @DisplayName("should return all animes on database")
    void whenGetAllAnimes_returnAllAnimes() throws Exception {
        // ARRANGE
        inMemoryAnimeRepository.db.add(MakeAnime.makeAnimeFactory(
    "Naruto", List.of(Genres.ACTION, Genres.ADVENTURE), null, null, null, null, null, null));
        inMemoryAnimeRepository.db.add(MakeAnime.makeAnimeFactory(
                "Sword Art Online", List.of(Genres.ACTION, Genres.ROMANCE), null, null, null, null, null, null));

        // ACT
        List<Anime> result = sut.execute();

        // ASSERT
        assertNotNull(result);
        assertEquals("Naruto", result.getFirst().getName());
        assertEquals("Sword Art Online", result.get(1).getName());
        assertEquals(Genres.ROMANCE, result.get(1).getGenresList().get(1));
    }

    @Test
    @DisplayName("should return error when try get all animes on database")
    void whenGetAllAnimes_returnResourceNotFoundException() {

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            sut.execute();
        });

        assertEquals("[Error] - Resource not found", exception.getMessage());
    }
}
