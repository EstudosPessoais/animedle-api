package com.example.animedle.services;

import com.example.animedle.entities.anime.Anime;
import com.example.animedle.repositories.IAnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetAllAnimes {

    private final IAnimeRepository animeRepository;

    @Autowired
    public GetAllAnimes(IAnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> execute() throws Exception {
        List<Anime> find = animeRepository.findAllAnimes();

        if(find.isEmpty()) {
            throw new Exception("[Error] - Resource not found");
        }

        return find;
    }
}
