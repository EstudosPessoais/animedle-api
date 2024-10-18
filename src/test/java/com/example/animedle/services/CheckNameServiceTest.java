package com.example.animedle.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.animedle.repositories.InMemoryGameTitleRepository;

class CheckNameServiceTest {

    private InMemoryGameTitleRepository gameTitleRepository;
    private CheckNameService sut; // System Under Test

    @BeforeAll
    void begin() {

    }

    @BeforeEach
    void setup() {
        gameTitleRepository = new InMemoryGameTitleRepository();
        sut = new CheckNameService(gameTitleRepository);
    }

    @Test
    void whenHasName_returnSuccessWithName() {
        gameTitleRepository.db.add()
    }
}
