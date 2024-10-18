package com.example.animedle.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class GameName extends RootEntity {

    private String name;
    private Date launchDate;

}