package com.example.animedle.database.mongodb;

import com.example.animedle.entities.Anime;
import com.example.animedle.repositories.IAnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AnimeRepository implements IAnimeRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Anime> findAllAnimes() {
        return mongoTemplate.findAll(Anime.class);
    }

    @Override
    public Anime findById(UUID animeId) {
        return mongoTemplate.findById(animeId, Anime.class);
    }
}
