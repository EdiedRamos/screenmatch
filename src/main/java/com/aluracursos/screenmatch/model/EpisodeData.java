package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeData(
        @JsonAlias("Title")
        String title,
        @JsonAlias("Year")
        Integer year,
        @JsonAlias("Runtime")
        String duration,
        @JsonAlias("imdbRating")
        String rating
) {}
