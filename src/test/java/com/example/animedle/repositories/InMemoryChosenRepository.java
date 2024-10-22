package com.example.animedle.repositories;

import com.example.animedle.entities.Chosen;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryChosenRepository implements IChosenRepository {

    public List<Chosen> db = new ArrayList<>();

    @Override
    public Chosen create(Chosen chosenAnime) throws Exception {
        if(ObjectUtils.isEmpty(chosenAnime)) {
            throw new Exception("[Error] - Fail to save ChoosenAnime on database");
        }
        db.add(chosenAnime);
        return chosenAnime;
    }

    @Override
    public Chosen getAnimeOfTheDay(UUID animeId) {
        Optional<Chosen> animeChosen = db.stream().filter(item ->
            item.getChosenAnimeId().equals(animeId) &&
            item.getChosenDate().equals(LocalDate.now().toString())
        ).findFirst();

        return animeChosen.orElse(null);

    }
}
