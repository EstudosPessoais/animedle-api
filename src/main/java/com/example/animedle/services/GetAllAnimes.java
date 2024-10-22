package com.example.animedle.services;

import com.example.animedle.entities.Anime;
import com.example.animedle.errors.ResourceNotFoundException;
import com.example.animedle.repositories.IAnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAnimes {

    private final IAnimeRepository animeRepository;

    @Autowired
    public GetAllAnimes(IAnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> execute() throws ResourceNotFoundException {
        var find = animeRepository.findAllAnimes();

        if(find.isEmpty()) {
            throw new ResourceNotFoundException("[Error] - Resource not found");
        }

        return find;
    }
}
