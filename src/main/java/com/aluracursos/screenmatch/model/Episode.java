package com.aluracursos.screenmatch.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episode {
    private Integer season;
    private String title;
    private Integer episode;
    private Double rating;
    private LocalDate release;

    private void setSafeRating(String rating) {
        try {
            this.rating = Double.valueOf(rating);
        } catch(NumberFormatException e) {
            this.rating = 0.0;
        }
    }

    private void setSafeRelease(String release) {
        try {
            this.release = LocalDate.parse(release);
        } catch (DateTimeException e) {
            this.release = null;
        }
    }

    public Episode(String season, EpisodeData data) {
        this.season = Integer.valueOf(season);
        this.title = data.title();
        this.episode = Integer.valueOf(data.episode());
        setSafeRating(data.rating());
        setSafeRelease(data.released());
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return "[Episode: " + title +
                ",\nTemporada: " + season +
                ",\nEpisode#: " + episode +
                ",\nRating: " + rating +
                ",\nFecha de publicación: " + release +
                "]\n";
    }
}
