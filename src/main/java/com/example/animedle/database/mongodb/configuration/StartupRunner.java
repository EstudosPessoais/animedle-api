package com.example.animedle.database.mongodb.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final DatabaseInitializer databaseInitializer;

    public StartupRunner(DatabaseInitializer databaseInitializer) {
        this.databaseInitializer = databaseInitializer;
    }

    @Override
    public void run(String... args) throws Exception {
        databaseInitializer.initializeDatabase();
    }

}
