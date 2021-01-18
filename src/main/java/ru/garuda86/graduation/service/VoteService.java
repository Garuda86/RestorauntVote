package ru.garuda86.graduation.service;

import org.springframework.transaction.annotation.Transactional;
import ru.garuda86.graduation.model.Restaurant;
import ru.garuda86.graduation.model.Vote;
import ru.garuda86.graduation.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static ru.garuda86.graduation.util.ValidationUtil.checkNotFoundWithId;

public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public VoteService(VoteRepository voteRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

    public Vote get(int id) {
        return checkNotFoundWithId(voteRepository.findById(id).orElse(null), id);
    }

    @Transactional
    public void delete(int id, int userId) throws Exception {
        //Todo checkRole
        checkNotFoundWithId(voteRepository.delete(id, userId), id);
    }

    @Transactional
    public Vote create (Vote vote, Integer userId) {
        if (!vote.isNew() && get(vote.getId()) == null) {
            return null;
        }
        vote.setUser(userRepository.getOne(userId));
        vote.setDateTime(LocalDateTime.now());


        return voteRepository.save(vote);
    }
}
