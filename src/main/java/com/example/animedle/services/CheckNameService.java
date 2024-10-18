package com.example.animedle.services;

import org.springframework.stereotype.Service;

@Service
public class CheckNameService {

    public String execute(String name) {
        if (name.equals("oi")) {
            return "OK";
        }

        return "N OK";
    }
}
