package com.aluracursos.screenmatch.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private Integer totalSeasons;
    private Double rating;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @OneToMany(mappedBy = "series")
    private List<Episode> episodes;

    public Series() {}

    private Double toDouble(String rating) {
        try {
            return Double.parseDouble(rating);
        } catch(Exception e) {
            return 0.0;
        }
    }

    public Series(SerieData serieData) {
        this.title = serieData.title();
        this.totalSeasons = serieData.totalSeasons();
        this.rating = toDouble(serieData.rating());
        this.genre = Genre.fromString(serieData.genre().split(",")[0].trim());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "~".repeat(10) +  "\nId: " + id + "\nTitle: " + title +
                "\nTotal seasons: " + totalSeasons + "\nRating: " + rating +
                "\nGenre: " + genre +
                "\n" + "~".repeat(10) + "\n";
    }
}
