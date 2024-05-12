package com.aluracursos.screenmatch.model;

import javax.sql.CommonDataSource;

public enum Genre {
    ACTION("Action"),
    ROMANCE("Romance"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    CRIME("Crime"),
    THRILLER("Thriller");

    private final String omdbGenre;

    Genre (String omdbGenre) {
        this.omdbGenre = omdbGenre;
    }

    public static Genre fromString(String comingGenre) {
        for (Genre genre: Genre.values()) {
            if (genre.omdbGenre.equalsIgnoreCase(comingGenre)) {
                return genre;
            }
        }
        throw new IllegalArgumentException(comingGenre + " not found in Genre enum");
    }
}
