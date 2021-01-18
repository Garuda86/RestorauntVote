package ru.garuda86.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.garuda86.graduation.model.MenuItem;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    @Modifying
    @Query("delete from MenuItem m WHERE m.dish.id = :id ")
    int delete(@Param("id") Integer id);

    @Modifying
    @Query("delete from MenuItem m where m.restaurant.id = :id")
    void deleteWithRestaurantId(@Param("id") Integer id);

    @Query("SELECT m FROM MenuItem m WHERE m.restaurant.id=:restaurantId ORDER BY m.id ASC")
    List<MenuItem> getByRestaurant(@Param("restaurantId") Integer restaurantId);

    //List<MenuItem> getAllByDate(@NotNull LocalDateTime dateTime);
}
