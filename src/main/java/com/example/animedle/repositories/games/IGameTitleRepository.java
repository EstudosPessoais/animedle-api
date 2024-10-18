package com.example.animedle.repositories.games;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.animedle.entities.GameName;

@Component
public interface IGameTitleRepository {
    public Optional<GameName> findAnimeByName(String name);
}
