package com.example.animedle.database.mongodb;

import com.example.animedle.entities.Chosen;
import com.example.animedle.repositories.IChosenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Repository
public class ChosenRepository implements IChosenRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Chosen create(Chosen chosenAnime) throws Exception {
        if(ObjectUtils.isEmpty(chosenAnime)) {
            throw new Exception("[Error] - Can't save on database");
        }
        mongoTemplate.insert(chosenAnime, "chosens");
        return chosenAnime;
    }

    @Override
    public Chosen getAnimeOfTheDay(UUID animeId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("chosenAnimeId").is(animeId));

        Chosen chosen = mongoTemplate.findOne(query, Chosen.class);

        if(ObjectUtils.isEmpty(chosen)) {
            return null;
        }
        return chosen;
    }
}
