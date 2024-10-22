package com.example.animedle.services;

import com.example.animedle.entities.Anime;
import com.example.animedle.entities.Chosen;
import com.example.animedle.repositories.IAnimeRepository;
import com.example.animedle.repositories.IChosenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ChooseAnime {

    private final IChosenRepository chosenRepository;
    private final IAnimeRepository animeRepository;
    private final static Logger log = LoggerFactory.getLogger(ChooseAnime.class);

    @Autowired
    public ChooseAnime(IChosenRepository chosenRepository, IAnimeRepository animeRepository) {
        this.chosenRepository = chosenRepository;
        this.animeRepository = animeRepository;
    }

    public void execute() throws Exception {
        log.info("[ChooseAnime] - Start CRON!");
        List<Anime> allAnimes = animeRepository.findAllAnimes();
        int indexChoosed = new Random().nextInt(allAnimes.size());

        Anime animeChoosed = allAnimes.get(indexChoosed);

        Chosen chosen = new Chosen(animeChoosed.getId(), null);

        chosenRepository.create(chosen);
    }
}
