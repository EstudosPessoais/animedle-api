package com.example.animedle.factories;

import java.util.UUID;

import org.assertj.core.util.DateUtil;

import com.example.animedle.entities.GameName;

import ch.qos.logback.core.util.StringUtil;
import jakarta.annotation.Nullable;

public class makeGameName {

    public static GameName create(@Nullable UUID idGameName, String nameGameName, String launchDateGameName) {
        return GameName.builder()
                .id(StringUtil.isNullOrEmpty(idGameName.toString()) ? idGameName : UUID.randomUUID())
                .name(nameGameName)
                .launchDate(DateUtil.parse(launchDateGameName))
                .createdAt(DateUtil.now())
                .updatedAt(DateUtil.now())
                .build();

    }
}
