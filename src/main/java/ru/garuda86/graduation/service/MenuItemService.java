package ru.garuda86.graduation.service;

import org.springframework.stereotype.Service;
import ru.garuda86.graduation.model.Dish;
import ru.garuda86.graduation.model.MenuItem;
import ru.garuda86.graduation.model.Restaurant;
import ru.garuda86.graduation.repository.DishRepository;
import ru.garuda86.graduation.repository.MenuItemRepository;
import ru.garuda86.graduation.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.garuda86.graduation.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuItemService(MenuItemRepository menuItemRepository, DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<MenuItem> getAll() {
        List<MenuItem> list = menuItemRepository.findAll();
        return list;
    }


    public MenuItem get(int id) {
        return checkNotFoundWithId(menuItemRepository.findById(id).orElse(null), id);
    }

    public List<MenuItem> getByRestaurant(int restaurantId) {
        return checkNotFoundWithId(menuItemRepository.getByRestaurant(restaurantId), restaurantId);
    }


    public void delete(int id) throws Exception {
        //Todo checkRole
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(() -> new Exception("dish not found"));
        checkNotFoundWithId(menuItemRepository.delete(menuItem.getId()), id);
    }

    public MenuItem create(MenuItem menuItem) throws Exception {
        //Todo checkRole
        return menuItemRepository.saveAndFlush(menuItem);

    }

    public MenuItem update(MenuItem menuItem, int id) {
        //Todo checkRole
        Dish dish = dishRepository.getOne(id);
        menuItem.setDish(dish);
        return menuItemRepository.save(menuItem);
    }

}
