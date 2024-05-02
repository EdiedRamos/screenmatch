package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.model.Episode;
import com.aluracursos.screenmatch.model.EpisodeData;
import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.SerieData;
import com.aluracursos.screenmatch.service.APIConsumer;
import com.aluracursos.screenmatch.service.DataConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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

//        List<EpisodeData> episodeData = seasonsData.stream().flatMap(t -> t.episodes().stream()).collect(Collectors.toList());

//        Top 5 episodes
//        System.out.println("️️✔️TOP 5 EPISODES✔️");
//        episodeData.stream().sorted(Comparator.comparing(EpisodeData::rating).reversed()).limit(5).forEach(System.out::println);


//        Set Episode
        List<Episode> episode = seasonsData.
                stream().flatMap(s -> s.episodes().stream()
                        .map(e -> new Episode(e.episode(), e))).collect(Collectors.toList());
//
//        episode.forEach(System.out::println);

//        Filter by date
//        System.out.println("Año de lanzamiento: ");
//        int year = scanner.nextInt();
//        scanner.nextLine();
//        LocalDate startYear = LocalDate.of(year, 1, 1);
//
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episode.stream()
//                .filter(e -> e.getRelease() != null &&  e.getRelease().isAfter(startYear))
//                .forEach(e -> System.out.println(
//                        "Title: " + e.getTitle()
//                        + "\nRelease: " + e.getRelease().format(dateTimeFormatter)
//                ));

        Map<Integer, Double> seasonAverage = episode.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.groupingBy(Episode::getSeason, Collectors.averagingDouble(Episode::getRating)));

        System.out.println(seasonAverage);

        DoubleSummaryStatistics est = episode.stream()
                .filter(e -> e.getRating() > 0.0)
                .collect(Collectors.summarizingDouble(Episode::getRating));

        System.out.println(est);
    }
}
