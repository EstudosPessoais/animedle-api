package com.example.animedle.core;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class RootEntity {

    private UUID id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
