package ru.garuda86.graduation;

import ru.garuda86.graduation.model.Vote;
//import ru.garuda86.graduation.to.VoteTo;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.LocalDateTime.of;
import static ru.garuda86.graduation.model.AbstractBaseEntity.START_SEQ;

public class VoteTestData {
    public static final TestMatcher<Vote> MEAL_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Vote.class, "user");
    //public static TestMatcher<VoteTo> MEAL_TO_MATCHER = TestMatcher.usingEqualsComparator(VoteTo.class);

    public static final int NOT_FOUND = 10;
    public static final int VOTE1_ID = START_SEQ + 30;
    public static final int ADMIN_VOTE_ID = START_SEQ + 33;

    //VALUES ('2020-12-30 10:00:00', 100000, 100002), --100030
    //       ('2020-12-30 13:00:00', 100000, 100002), --100031
    //       ('2020-12-31 11:00:00', 100000, 100005), --100032
    //       ('2020-12-31 10:00:00', 100001, 100005), --100033
    //       ('2021-01-11 13:00:00', 100001, 100006), --100034
    //       ('2021-01-11 14:00:00', 100001, 100006); --100035

    public static final Vote vote1 = new Vote(VOTE1_ID, of(2020, Month.DECEMBER, 30, 9, 0));
    public static final Vote vote2 = new Vote(VOTE1_ID + 1, of(2020, Month.DECEMBER, 30, 12, 0));
    public static final Vote vote3 = new Vote(VOTE1_ID + 2, of(2020, Month.DECEMBER, 31, 11, 30));
    //public static final Vote vote4 = new Vote(VOTE1_ID + 3, of(2020, Month.JANUARY, 31, 0, 0));
    //public static final Vote vote5 = new Vote(VOTE1_ID + 4, of(2020, Month.JANUARY, 31, 10, 0));
    //public static final Vote vote6 = new Vote(VOTE1_ID + 5, of(2020, Month.JANUARY, 31, 13, 0));

    public static final Vote adminVote1 = new Vote(ADMIN_VOTE_ID, of(2020, Month.DECEMBER, 31, 10, 0));
    public static final Vote adminVote2 = new Vote(ADMIN_VOTE_ID + 1, of(2021, Month.JANUARY, 11, 13, 0));
    public static final Vote adminVote3 = new Vote(ADMIN_VOTE_ID + 2, of(2021, Month.JANUARY, 11, 14, 0));

    public static final List<Vote> votes = List.of(vote3, vote2, vote1);

    public static Vote getNew() {
        return new Vote(null, of(2020, Month.FEBRUARY, 1, 18, 0));
    }

    public static Vote getUpdated() {
        return new Vote(VOTE1_ID, vote1.getDateTime().plus(2, ChronoUnit.MINUTES));
    }
}
