package com.joealexanderIII.dao;

import com.joealexanderIII.model.Player;
import com.joealexanderIII.model.Role;
import com.joealexanderIII.model.User;
import com.joealexanderIII.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hibernate.type.descriptor.java.JdbcTimestampTypeDescriptor.TIMESTAMP_FORMAT;
import static org.junit.jupiter.api.Assertions.*;

class PlayerDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Player.class);

        Database database = Database.getInstance();
        database.runSQL("cleanTestDB.sql");

    }

    @Test
    void getAllPlayersForAUserSuccess() {

        User specificUser = (User)genericDao.getById(1);
        assertEquals(0, specificUser.getPlayers().size());

        specificUser = (User)genericDao.getById(2);
        assertEquals(2, specificUser.getPlayers().size());
    }

    @Test
    void getPlayerByIdSuccess() {

        Player specificPlayer = (Player) genericDao.getById(1);
        assertEquals("Jenkin", specificPlayer.getPlayerFirstName());

//        specificPlayer = (Player)genericDao.getById(2);
//        assertEquals("12u", specificPlayer.getPlayerAgeGroup());
    }
    @Test
    void insert() {

        User specificUser = (User)genericDao.getById(1);
        assertEquals(0, specificUser.getPlayers().size());

        specificUser = (User)genericDao.getById(2);
        assertEquals(2, specificUser.getPlayers().size());
    }

}