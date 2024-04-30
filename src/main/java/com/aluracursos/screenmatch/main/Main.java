package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.model.EpisodeData;
import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.SerieData;
import com.aluracursos.screenmatch.service.APIConsumer;
import com.aluracursos.screenmatch.service.DataConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final String API_KEY = "9a9b70da";
    private final String BASE_URL = "http://www.omdbapi.com/?apikey={API_KEY}".replace("{API_KEY}", API_KEY);
    private final Scanner scanner = new Scanner(System.in);
    private final APIConsumer api = new APIConsumer();
    private final DataConverter converter = new DataConverter();

    public void showMenu() {
        System.out.println("Nombre de la serie:");
        String name = scanner.nextLine();
        var currentURL = BASE_URL.concat("&t=" + name.replace(" ", "+"));
        var serie = api.getData(currentURL);
        var serieData = converter.getData(serie, SerieData.class);

//        System.out.println(serieData);

        List<SeasonData> seasonsData = new ArrayList<>();

        for (int season = 1; season <= serieData.totalSeasons(); season++) {
            var currentSeason = api.getData(currentURL.concat("&season=" + season));
            var seasonData = converter.getData(currentSeason, SeasonData.class);
            seasonsData.add(seasonData);
        }

//      Show all episode titles
//        seasonsData.forEach(season -> season.episodes().forEach(episode -> System.out.println(episode.title())));

//      Set episode data

        List<EpisodeData> episodeData = seasonsData.stream().flatMap(t -> t.episodes().stream()).collect(Collectors.toList());

//        Top 5 episodes
        System.out.println("️️✔️TOP 5 EPISODES✔️");
        episodeData.stream().sorted(Comparator.comparing(EpisodeData::rating).reversed()).limit(5).forEach(System.out::println);

    }
}
