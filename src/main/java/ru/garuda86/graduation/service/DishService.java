package ru.garuda86.graduation.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.garuda86.graduation.model.Dish;
import ru.garuda86.graduation.repository.DishRepository;
import ru.garuda86.graduation.repository.MenuItemRepository;
import ru.garuda86.graduation.to.DishTo;
import ru.garuda86.graduation.util.DishUtil;

import java.util.List;

import static ru.garuda86.graduation.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {
    private final DishRepository dishRepository;


    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;

    }


    public List<Dish> getAll() {
        List<Dish> list = dishRepository.findAll();
        return list;
    }

    public Dish get(int id) {
        return checkNotFoundWithId(dishRepository.findById(id).orElse(null), id);
    }

    public Dish create(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        return dishRepository.save(dish);
    }


    public void delete(int id) throws Exception {
        //Dish dish = dishRepository.findById(id).orElseThrow(() -> new Exception("dish not found"));
        checkNotFoundWithId(dishRepository.delete(id), id);

    }

    @CacheEvict(value = "dishes", allEntries = true)
    public void update(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        dishRepository.save(dish);
    }

    @CacheEvict(value = "dishes", allEntries = true)
    @Transactional
    public void update(DishTo dishTo) {
        Dish dish = get(dishTo.id());
        dishRepository.save(DishUtil.updateFromTo(dish, dishTo));
    }
}
