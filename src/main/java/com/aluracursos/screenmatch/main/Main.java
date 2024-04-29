package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.SerieData;
import com.aluracursos.screenmatch.service.APIConsumer;
import com.aluracursos.screenmatch.service.DataConverter;

import java.util.Scanner;

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

        System.out.println(serieData);

        for (int season = 1; season <= serieData.totalSeasons(); season++) {
			var currentSeason = api.getData(currentURL.concat("&season=" + season));
			var seasonData = converter.getData(currentSeason, SeasonData.class);
			System.out.println("~~~~~ SEASON " + season + " ~~~~~");
			System.out.println(seasonData);
			System.out.println("~".repeat(10));
		}
    }
}
