package com.aluracursos.screenmatch.main;


import java.util.Arrays;
import java.util.List;

public class StreamExamples {
    public void example() {
        List<String> names = Arrays.asList("Elliot", "Edied", "Darlene", "Whiterose", "Mr. robot");
        names.stream()
                .sorted()
                .filter(n -> n.length() > 5 && n.length() < 8)
                .map(String::toUpperCase)
                .limit(3)
                .forEach(System.out::println);
    }
}
