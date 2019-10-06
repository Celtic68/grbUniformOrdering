package com.joealexanderIII.dao;

import com.joealexanderIII.model.Player;
import com.joealexanderIII.model.UniformOrder;
import com.joealexanderIII.model.User;
import com.joealexanderIII.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UniformOrderDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(UniformOrder.class);

        Database database = Database.getInstance();
        database.runSQL("cleanTestDB.sql");

    }

    @Test
    void getAllUniformOrdersForAPlayerSuccess() {

        GenericDao genericPlayerDao = new GenericDao(Player.class);

        Player specificPlayer = (Player)genericPlayerDao.getById(1);
        assertEquals(1, specificPlayer.getOrders().size());

        specificPlayer = (Player)genericPlayerDao.getById(2);
        assertEquals(2, specificPlayer.getOrders().size());
    }

    @Test
    void getUniformOrderByIdSuccess() {

        UniformOrder specificUniformOrder = (UniformOrder)genericDao.getById(1);
        assertEquals(13, specificUniformOrder.getShoeSize());
    }

    @Test
    void deleteByRemovingAUser() {

        GenericDao genericUserDao = new GenericDao(User.class);

        genericUserDao.delete(genericUserDao.getById(2));
        assertNull(genericUserDao.getById(2));
        assertNull(genericDao.getById(1));
        assertNull(genericDao.getById(2));

    }

    @Test
    void deleteByRemovingAPlayer() {

        GenericDao genericPlayerDao = new GenericDao(Player.class);

        genericPlayerDao.delete(genericPlayerDao.getById(2));
        assertNull(genericPlayerDao.getById(2));
        assertNull(genericDao.getById(2));
        assertNull(genericDao.getById(3));

    }

    @Test
    void deleteAnOrder() {

        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));

    }

    @Test
    void saveOrUpdateToUpdateAUniformOrderSuccess() {

        // Update a uniform order
        GenericDao genericPlayerDao = new GenericDao(Player.class);

        Player specificPlayer = (Player)genericPlayerDao.getById(2);
        List<UniformOrder> uniformOrders = specificPlayer.getOrders();
        LocalDateTime date = LocalDateTime.now();

        int jerseyNumber = 36;
        int tshirtSize = 3;
        int shortsSize = 3;

        boolean orderFound = false;

        for (UniformOrder uniformOrder: uniformOrders) {
            if (uniformOrder.getDateCreated().getYear() == date.getYear()
                    && uniformOrder.getDateCreated().getMonthValue() >= (date.getMonthValue() - 2)) {
                uniformOrder.setJerseyNumber(jerseyNumber);
                uniformOrder.settShirtSize(tshirtSize);
                uniformOrder.setShortsSize(shortsSize);
                specificPlayer.setOrders(uniformOrders);
                uniformOrder.setPlayer(specificPlayer);
                genericPlayerDao.saveOrUpdate(specificPlayer);
                orderFound = true;
                break;
            }
        }

        Player insertedPlayer = (Player)genericPlayerDao.getById(2);
        assertEquals(specificPlayer, insertedPlayer);

    }

    @Test
    void saveOrUpdateToInsertANewUniformOrderSuccess() {

        GenericDao genericPlayerDao = new GenericDao(Player.class);

        Player specificPlayer = (Player)genericPlayerDao.getById(1);
        List<UniformOrder> uniformOrders = specificPlayer.getOrders();
        LocalDateTime date = LocalDateTime.now();

        UniformOrder uniformOrderEntered = new UniformOrder(4, 87, 2, 1, 2, 3, null, null, 3, date);
        int jerseyNumber = 36;
        int tshirtSize = 3;
        int shortsSize = 3;

        boolean orderFound = false;

        for (UniformOrder uniformOrder: uniformOrders) {
            if (uniformOrder.getDateCreated().getYear() == date.getYear()
                    && uniformOrder.getDateCreated().getMonthValue() >= (date.getMonthValue() - 2)) {
                uniformOrder.setJerseyNumber(jerseyNumber);
                uniformOrder.settShirtSize(tshirtSize);
                uniformOrder.setShortsSize(shortsSize);
                specificPlayer.setOrders(uniformOrders);
                uniformOrder.setPlayer(specificPlayer);
                genericPlayerDao.saveOrUpdate(specificPlayer);
                orderFound = true;
                break;
            }
        }

        if (!orderFound) {
            uniformOrders.add(uniformOrderEntered);
            specificPlayer.setOrders(uniformOrders);
            uniformOrderEntered.setPlayer(specificPlayer);
            genericPlayerDao.saveOrUpdate(specificPlayer);
        }

        Player insertedPlayer = (Player)genericPlayerDao.getById(1);
        assertEquals(specificPlayer, insertedPlayer);


    }

    @Test
    void getAllPlayersAndOrdersForAgeGroupSuccess() {

        // Insert new players and orders
        GenericDao genericUserDao = new GenericDao(User.class);
        User specificUser = (User)genericUserDao.getById(1);
        Set<Player> players = specificUser.getPlayers();

        LocalDateTime date = LocalDateTime.now();

        Player newPlayer1 = new Player("Rollie", "Fingers", 2, "12u");
        UniformOrder uniformOrderEntered = new UniformOrder(4, 88, 2, 1, 2, 3, null, null, 3, date);
        List<UniformOrder> orderList = newPlayer1.getOrders();
        orderList.add(uniformOrderEntered);
        newPlayer1.setOrders(orderList);
        uniformOrderEntered.setPlayer(newPlayer1);
        players.add(newPlayer1);

        Player newPlayer2 = new Player("Joel", "Haloer", 3, "12u");
        uniformOrderEntered = new UniformOrder(4, 89, 2, 1, 2, 3, null, null, 3, date);
        orderList = newPlayer2.getOrders();
        orderList.add(uniformOrderEntered);
        newPlayer2.setOrders(orderList);
        uniformOrderEntered.setPlayer(newPlayer2);
        players.add(newPlayer2);

        newPlayer1.setUser(specificUser);
        newPlayer2.setUser(specificUser);
        specificUser.setPlayers(players);

        genericUserDao.saveOrUpdate(specificUser);

        GenericDao genericPlayerDao = new GenericDao(Player.class);
        List<Player> playerList = genericPlayerDao.getByPropertyListEqual("playerAgeGroup", "12u");
        assertEquals(3, playerList.size());

        List<UniformOrder> twelveUOrders = new ArrayList();
        List<UniformOrder> playerOrders;;
        for(Player player: playerList) {
            playerOrders = player.getOrders();
            for(UniformOrder order: playerOrders) {
                if (order.getDateCreated().getYear() == date.getYear()
                        && order.getDateCreated().getMonthValue() >= (date.getMonthValue() - 2)) {
                    twelveUOrders.add(order);
                }
            }
        }

        assertEquals(3, twelveUOrders.size());

    }

}
