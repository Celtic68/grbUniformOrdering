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
import java.util.Set;

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

        GenericDao genericUserDao = new GenericDao(User.class);

        User specificUser = (User)genericUserDao.getById(1);
        assertEquals(0, specificUser.getPlayers().size());

        specificUser = (User)genericUserDao.getById(2);
        assertEquals(2, specificUser.getPlayers().size());
    }

    @Test
    void getPlayerByIdSuccess() {

        Player specificPlayer = (Player) genericDao.getById(1);
        assertEquals("Jenkin", specificPlayer.getPlayerFirstName());

        specificPlayer = (Player)genericDao.getById(2);
        assertEquals("12u", specificPlayer.getPlayerAgeGroup());

    }
    @Test
    void saveOrUpdatePlayers() {

        // Insert new players
        GenericDao genericUserDao = new GenericDao(User.class);
        User specificUser = (User)genericUserDao.getById(1);
        Set<Player> players = specificUser.getPlayers();

        Player newPlayer1 = new Player("Rollie", "Fingers", 2, "13u");
        players.add(newPlayer1);
        Player newPlayer2 = new Player("Joel", "Haloer", 3, "16u");
        players.add(newPlayer2);

        newPlayer1.setUser(specificUser);
        newPlayer2.setUser(specificUser);
        specificUser.setPlayers(players);

        genericUserDao.saveOrUpdate(specificUser);

        User updatedUser = (User)genericUserDao.getById(1);
        assertEquals(2, updatedUser.getPlayers().size());
        assertEquals(specificUser, updatedUser);

        specificUser = (User)genericUserDao.getById(2);
        assertEquals(2, specificUser.getPlayers().size());

        // Update a player
        Player specificPlayer = (Player)genericDao.getById(2);

        String newFirstName = "Connor";
        specificPlayer.setPlayerFirstName(newFirstName);

        genericUserDao.saveOrUpdate(specificPlayer);

        Player updatedPlayer = (Player)genericDao.getById(2);
        assertEquals(specificPlayer, updatedPlayer);

    }

    @Test
    void getPlayerByLastNameSuccess() {

        List<Player> searchPlayers = genericDao.getByPropertyLike("playerLastName", "lex");
        assertEquals(2, searchPlayers.size());

    }

    @Test
    void getPlayerByFirstNameSuccess() {

        List<Player> searchPlayers =genericDao.getByPropertyLike("playerFirstName", "Jenk");
        assertEquals(1, searchPlayers.size());

    }

    @Test
    void getPlayerByAgeGroupSuccess() {

        List<Player> searchPlayers = genericDao.getByPropertyListEqual("playerAgeGroup", "15u");
        assertEquals(1, searchPlayers.size());

    }

    @Test
    void getPlayerBySiteLocationSuccess() {

        List<Player> searchPlayers = genericDao.getByPropertyListEqual("playerSiteLocation", "1");
        assertEquals(2, searchPlayers.size());

    }
    @Test
    void getPlayerBySiteLocationNoPlayersSuccess() {

        List<Player> searchPlayers = genericDao.getByPropertyListEqual("playerSiteLocation", "3");
        assertEquals(0, searchPlayers.size());

    }

    @Test
    void deleteUserAndPlayers() {

        GenericDao genericUserDao = new GenericDao(User.class);

        genericUserDao.delete(genericUserDao.getById(2));
        assertNull(genericUserDao.getById(2));
        assertNull(genericDao.getById(1));
        assertNull(genericDao.getById(2));

    }

    @Test
    void deletePlayer() {

        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));

    }

}