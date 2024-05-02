package com.aluracursos.screenmatch.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        Optional<Integer> evenNumber = numbers.parallelStream().filter(x -> x % 2 == 0).peek(x -> System.out.println("Value: " + x)).findAny();
        if (evenNumber.isPresent()) {
            System.out.println(evenNumber.get());
        } else {
            System.out.println("Not even number found");
        }
    }
}
