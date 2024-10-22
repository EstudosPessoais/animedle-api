package com.example.animedle.database.mongodb.configuration;

import com.example.animedle.entities.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DatabaseInitializer {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public DatabaseInitializer(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public void initializeDatabase() {
        String collectionName = "animes";

        if (!mongoTemplate.collectionExists(collectionName)) {
            mongoTemplate.createCollection(collectionName);
            System.out.println("MongoDB Create - Name: 'animes'");

            List<Anime> animes = FactoryAnimeSeed.seedAnimeDb();
            UUID firstChosen = animes.getFirst().getId();
            mongoTemplate.insert(animes, collectionName);
            mongoTemplate.insert(FactoryChosenSeed.makeChosenFactory(firstChosen),"chosens");
            System.out.println("[DATABASE] - Input data!");
        } else {
            System.out.println("DB was already created");
        }
    }
}
