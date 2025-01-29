package com.example;

import java.util.List;

public interface Predator {

    List<String> eatMeat() throws Exception;

    int getKittens();

    int getKittens(int kittensCount);

    List<String> getFood(String animalKind) throws Exception;

}
