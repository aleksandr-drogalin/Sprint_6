package com.example;

import java.util.HashSet;
import java.util.List;

public class Alex extends Lion {

    //Создаем конструктор класса Алекс
    public Alex(Feline feline) throws Exception {
       super("Самец", feline);
    }

    //Создаем метод, который возвращает список друзей Алекса
    public List<String> getFriends() {
        return List.of("Марти","Глория","Мелман");
    }

    //Создаем метод, который возвращает место в котором живет Алекс
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    //Переопределяем метод возращающий количество детей Алекса
    @Override
    public int getKittens() {
        return 0;
    }
}
