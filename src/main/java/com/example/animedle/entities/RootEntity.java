package com.example.animedle.entities;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class RootEntity {

    private UUID id;
    private Date createdAt;
    private Date updatedAt;
}
