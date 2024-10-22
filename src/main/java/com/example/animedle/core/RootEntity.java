package com.example.animedle.core;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public abstract class RootEntity {

    @Id
    private UUID id;

    @CreatedDate
    @Field("created_at")
    private LocalDate createdAt;

    @LastModifiedDate
    @Field("updated_at")
    private LocalDate updatedAt;

    protected RootEntity(@Nullable UUID id, @Nullable LocalDate createdAt, @Nullable LocalDate updatedAt) {
        this.id = Optional.ofNullable(id).orElse(UUID.randomUUID());
        this.createdAt = Optional.ofNullable(createdAt).orElse(LocalDate.now());
        this.updatedAt = Optional.ofNullable(updatedAt).orElse(LocalDate.now());
    }

    protected RootEntity() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }
}
