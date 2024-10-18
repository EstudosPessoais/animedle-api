package com.example.animedle.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.animedle.entities.GameName;
import com.example.animedle.repositories.games.IGameTitleRepository;

import ch.qos.logback.core.util.StringUtil;

// [] TODO - Colocar nova exception para input invalido;

@Service
public class CheckNameService {

    private final IGameTitleRepository gameTitleRepository;

    @Autowired
    public CheckNameService(IGameTitleRepository gameTitleRepository) {
        this.gameTitleRepository = gameTitleRepository;
    }

    public String execute(String name) throws Exception {

        if (StringUtil.isNullOrEmpty(name)) {
            throw new Exception("Name null");
        }

        Optional<GameName> anime = gameTitleRepository.findAnimeByName(name);
        if (anime.isPresent()) {
            return anime.get().getName();
        }

        return "";
    }
}
