package com.example.animedle.services;

import com.example.animedle.entities.Anime;
import com.example.animedle.entities.Chosen;
import com.example.animedle.errors.ResourceNotFoundException;
import com.example.animedle.repositories.IAnimeRepository;
import com.example.animedle.repositories.IChosenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
public class CheckAnimeCorrect {

    private final IChosenRepository chosenRepository;
    private final IAnimeRepository animeRepository;

    public CheckAnimeCorrect(IChosenRepository chosenRepository, IAnimeRepository animeRepository) {
        this.chosenRepository = chosenRepository;
        this.animeRepository = animeRepository;
    }

    public Anime execute(UUID animeId) throws ResourceNotFoundException {

        Chosen findAnime = chosenRepository.getAnimeOfTheDay(animeId);
        if(ObjectUtils.isEmpty(findAnime)) {
            return null;
        }

        Anime findAnimeContext = animeRepository.findById(findAnime.getChosenAnimeId());
        if(ObjectUtils.isEmpty(findAnimeContext)) {
            throw new ResourceNotFoundException("[Error] - Anime didn't found");
        }

        return findAnimeContext;
    }
}
