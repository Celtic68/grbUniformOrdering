package com.joealexanderIII.dao;

import com.joealexanderIII.model.User;
import com.joealexanderIII.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hibernate.type.descriptor.java.JdbcTimestampTypeDescriptor.TIMESTAMP_FORMAT;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao userDao;

    @BeforeEach
    void setUp() {

        userDao = new UserDao();

        Database database = Database.getInstance();
        database.runSQL("cleanTestDB.sql");

    }

    @Test
    void getAllUsersSuccess() {

        List<User> allUsers = userDao.getAllUsers();
        assertEquals(2, allUsers.size());
    }

    @Test
    void getUserByUserNameSuccess() {

        User specificUser = userDao.getUserByUserName("almfamily");
        assertEquals("Joseph", specificUser.getUserFirstName());
        assertEquals("Alexander", specificUser.getUserLastName());

    }

    @Test
    void getUserByIdSuccess() {

        User userById = userDao.getUserById(2);
        assertEquals("Jill", userById.getUserFirstName());
        assertEquals("Leitl", userById.getUserLastName());
    }

    @Test
    void getSearchCriteriaUsersByLastNameSuccess() {

        List<User> criteriaUsers = userDao.getSearchCriteriaUsers("l", "userLastName");
        assertEquals(2, criteriaUsers.size());

    }

    @Test
    void getSearchCriteriaUsersByFirstNameSuccess() {

        List<User> criteriaUsers = userDao.getSearchCriteriaUsers("i", "userFirstName");
        assertEquals(1, criteriaUsers.size());

    }

    @Test
    void saveOrUpdateFirstAndLastNameSuccess() {

        String newLastName = "Marley";
        String newFirstName = "Bob";
        User userToUpdate = userDao.getUserById(1);
        userToUpdate.setUserFirstName(newFirstName);
        userToUpdate.setUserLastName(newLastName);
        userDao.saveOrUpdate(userToUpdate);
        User retrieveUpdatedUser = userDao.getUserById(1);
        assertEquals(newFirstName, retrieveUpdatedUser.getUserFirstName());
        assertEquals(newLastName, retrieveUpdatedUser.getUserLastName());

    }

    @Test
    void insert() {

        LocalDateTime date = LocalDateTime.now();
        User newUser = new User("bevans","$2y$10$Z0k7T2ZWYJsI8z9WEzH5Bu5lOps/ph7MNNSwgeuJ8rilaTxxz6QBe","Bob","Evans","1234 Main St","","Beloit","WI","53590",6087720366L,"bevans@gmail.com", date);
        int id = userDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = userDao.getUserById(id);
        assertEquals("Bob", insertedUser.getUserFirstName());
        assertEquals("Evans", insertedUser.getUserLastName());
        assertEquals(6087720366L, insertedUser.getUserPhone());

    }

    @Test
    void delete() {

        userDao.delete(userDao.getUserById(2));
        assertNull(userDao.getUserById(2));

    }
}