package com.example.animedle.database.mongodb.configuration;

import com.example.animedle.entities.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
            mongoTemplate.insert(animes, collectionName);
            System.out.println("[DATABASE] - Input data!");
        } else {
            System.out.println("DB was already created");
        }
    }
}
