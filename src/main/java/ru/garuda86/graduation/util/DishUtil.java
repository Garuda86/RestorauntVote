package ru.garuda86.graduation.util;

import ru.garuda86.graduation.model.Dish;
import ru.garuda86.graduation.to.DishTo;

public class DishUtil {

    public static Dish updateFromTo(Dish dish, DishTo dishTo) {
        dish.setName(dishTo.getName());
        dish.setPrice(dishTo.getPrice());
        return dish;
    }
}
