package com.example.animedle.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.animedle.entities.GameName;
import com.example.animedle.repositories.games.IGameTitleRepository;

public class InMemoryGameTitleRepository implements IGameTitleRepository {
    public List<GameName> db = new ArrayList<>();

    @Override
    public Optional<GameName> findAnimeByName(String name) {
        Optional<GameName> find = db.stream().filter(item -> item.getName().equals(name)).findFirst();
        return find;
    }
}
