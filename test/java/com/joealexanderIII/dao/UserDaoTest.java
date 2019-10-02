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

    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleanTestDB.sql");

    }

    @Test
    void getAllUsersSuccess() {

        List<User> allUsers = genericDao.getAll();
        assertEquals(2, allUsers.size());
    }

    @Test
    void getUserByUserNameSuccess() {

        User specificUser = (User)genericDao.getByPropertyUniqueEqual("userName", "almfamily");
        assertEquals("Joseph", specificUser.getUserFirstName());
        assertEquals("Alexander", specificUser.getUserLastName());

    }

    @Test
    void getUserByIdSuccess() {

        User userById = (User)genericDao.getById(2);
        assertEquals("Jill", userById.getUserFirstName());
        assertEquals("Leitl", userById.getUserLastName());
    }

    @Test
    void getSearchCriteriaUsersByLastNameSuccess() {

        List<User> criteriaUsers = genericDao.getByPropertyLike("userLastName", "l");
        assertEquals(2, criteriaUsers.size());

    }

    @Test
    void getSearchCriteriaUsersByFirstNameSuccess() {

        List<User> criteriaUsers =genericDao.getByPropertyLike("userFirstName", "i");
        assertEquals(1, criteriaUsers.size());

    }

    @Test
    void getSearchCriteriaUsersByEmailSuccess() {

        List<User> criteriaUsers = genericDao.getByPropertyListEqual("userEmail", "cambo7131@gmail.com");
        assertEquals(2, criteriaUsers.size());

    }

    @Test
    void saveOrUpdateFirstAndLastNameSuccess() {

        String newLastName = "Marley";
        String newFirstName = "Bob";

        User userToUpdate = (User)genericDao.getById(1);
        userToUpdate.setUserFirstName(newFirstName);
        userToUpdate.setUserLastName(newLastName);

        genericDao.saveOrUpdate(userToUpdate);

        User retrieveUpdatedUser = (User)genericDao.getById(1);
        assertEquals(userToUpdate, retrieveUpdatedUser);

    }

    @Test
    void insert() {

        LocalDateTime date = LocalDateTime.now();
        User newUser = new User("bevans","$2y$10$Z0k7T2ZWYJsI8z9WEzH5Bu5lOps/ph7MNNSwgeuJ8rilaTxxz6QBe","Bob","Evans","1234 Main St","","Beloit","WI","53590",6087720366L,"bevans@gmail.com", date);

        int id = genericDao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);

        assertEquals(newUser, insertedUser);

    }

    @Test
    void delete() {

        genericDao.delete(genericDao.getById(2));
        assertNull(genericDao.getById(2));

    }
}