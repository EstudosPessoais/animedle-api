package com.example.animedle.services;

import com.example.animedle.entities.anime.Anime;
import com.example.animedle.entities.anime.Chosen;
import com.example.animedle.repositories.IAnimeRepository;
import com.example.animedle.repositories.IChosenRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class ChooseAnime {

    private final IChosenRepository chosenRepository;
    private final IAnimeRepository animeRepository;

    @Autowired
    public ChooseAnime(IChosenRepository chosenRepository, IAnimeRepository animeRepository) {
        this.chosenRepository = chosenRepository;
        this.animeRepository = animeRepository;
    }

    public void execute() throws Exception {
        List<Anime> allAnimes = animeRepository.findAllAnimes();
        int indexChoosed = new Random().nextInt(allAnimes.size());

        Anime animeChoosed = allAnimes.get(indexChoosed);

        Chosen chosen = Chosen.create(animeChoosed.getId());

        chosenRepository.create(chosen);
    }
}
