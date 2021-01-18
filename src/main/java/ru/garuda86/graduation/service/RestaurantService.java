package ru.garuda86.graduation.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.garuda86.graduation.model.Dish;
import ru.garuda86.graduation.model.MenuItem;
import ru.garuda86.graduation.model.Restaurant;
import ru.garuda86.graduation.repository.RestaurantRepository;

import java.util.List;

import static ru.garuda86.graduation.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(restaurantRepository.findById(id).orElse(null), id);
    }

    public void delete(int id) throws Exception {
        //Todo checkRole
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }

    public Restaurant create(Restaurant restaurant) throws Exception {
        //Todo checkRole
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);

    }

    public void update(Restaurant restaurant, int id) {
        //Todo checkRole
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(restaurantRepository.save(restaurant), restaurant.getId());
    }


}
