package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.main.Main;
import com.aluracursos.screenmatch.main.StreamExamples;
import com.aluracursos.screenmatch.model.EpisodeData;
import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.SerieData;
import com.aluracursos.screenmatch.repository.SeriesRepository;
import com.aluracursos.screenmatch.service.APIConsumer;
import com.aluracursos.screenmatch.service.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	@Autowired
	private SeriesRepository seriesRepository;
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var main = new Main(seriesRepository);
		main.showMenu();

//		var streamExamples = new StreamExamples();
//		streamExamples.example();
	}
}
