package ru.garuda86.graduation.to;

import ru.garuda86.graduation.model.*;

import java.util.List;

class RestaurantTo {
    private final Integer id;
    private final String name;
    private List<MenuItem> menu;
    private int voteCount;

    public RestaurantTo(Integer id, String name, List<MenuItem> menu, int voteCount) {
        this.id = id;
        this.name = name;
        this.menu = menu;
        this.voteCount = voteCount;
    }
}
