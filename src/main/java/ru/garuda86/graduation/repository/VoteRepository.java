package ru.garuda86.graduation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.garuda86.graduation.model.Dish;
import ru.garuda86.graduation.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
//    int delete(@Param("id") int id, @Param("userId") int restaurantId);

    @Modifying
    @Transactional
    @Query("delete from Vote v WHERE v.id=:id AND v.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Modifying
    @Transactional
    @Query("delete from Vote v WHERE v.id=:id AND v.user.id=:userId")
     Vote save(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId ORDER BY v.dateTime DESC")
    List<Dish> getAll(@Param("userId") int userId);

    @Query("SELECT v from Vote v WHERE v.user.id=:userId AND v.dateTime >= :startDate AND v.dateTime < :endDate ORDER BY v.dateTime DESC")
    List<Dish> getBetweenHalfOpen(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);

    /*@Query("SELECT v FROM Vote v JOIN FETCH v.restaurant WHERE m.id = ?1 and m.restaurant.id = ?2")
    Dish getWithRestaurant(int id, int restaurantId);*/

    @Modifying
    @Query("delete from Vote v where v.restaurant.id = :id")
    void deleteWithRestaurantId(@Param("id") int id);
}
