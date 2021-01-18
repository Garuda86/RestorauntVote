package ru.garuda86.graduation.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.garuda86.graduation.UserTestData;
import ru.garuda86.graduation.model.User;
import ru.garuda86.graduation.util.exception.NotFoundException;


import static ru.garuda86.graduation.UserTestData.ADMIN_ID;
import static ru.garuda86.graduation.UserTestData.USER_WITH_VOTES_MATCHER;


class UserServiceTest extends AbstractUserServiceTest {
    @Test
    void getWithVotes() {
        User admin = service.getWithVotes(ADMIN_ID);
        USER_WITH_VOTES_MATCHER.assertMatch(admin, UserTestData.admin);
    }

    @Test
    void getWithVotesNotFound() {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.getWithVotes(1));
    }
}