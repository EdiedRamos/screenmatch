package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.service.APIConsumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new APIConsumer();
//		var mrRobot = api.getData("http://www.omdbapi.com/?apikey=9a9b70da&t=mr+robot");
		var fakeUsers = api.getData("https://jsonplaceholder.typicode.com/users");
		System.out.println(fakeUsers);
	}
}
