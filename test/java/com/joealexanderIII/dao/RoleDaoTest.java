package com.joealexanderIII.dao;


import com.joealexanderIII.model.Role;
import com.joealexanderIII.model.User;
import com.joealexanderIII.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Role dao test.
 */
public class RoleDaoTest {

    /**
     * The Generic dao.
     */
    GenericDao genericDao;

    /**
     * Creating the Dao.
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Role.class);

        Database database = Database.getInstance();
        database.runSQL("cleanTestDB.sql");
    }

    /**
     * Gets admin role for user success.
     */
    @Test
    void getAdminRoleForUserSuccess() {

        Role userRole = (Role)genericDao.getByPropertyWithStringUniqueEqual("userName","almfamily");
        assertEquals("admin", userRole.getUserRole());
        assertEquals("Joseph", userRole.getUser().getUserFirstName());
    }

    /**
     * Gets user role for user success.
     */
    @Test
    void getUserRoleForUserSuccess() {

        Role userRole = (Role)genericDao.getByPropertyWithStringUniqueEqual("userName","jleitl");
        assertEquals("user", userRole.getUserRole());
        assertEquals("Leitl", userRole.getUser().getUserLastName());
    }

    @Test
    void insert() {

        GenericDao genericUserDao = new GenericDao(User.class);

        Role newRole = new Role("bevans", "user");

        LocalDateTime date = LocalDateTime.now();
        User newUser = new User("bevans", "$2y$10$Z0k7T2ZWYJsI8z9WEzH5Bu5lOps/ph7MNNSwgeuJ8rilaTxxz6QBe","Bob","Evans","1234 Main St","","Beloit","WI","53590",6087720366L,"bevans@gmail.com", date, newRole);

        newRole.setUser(newUser);
        int id = genericDao.insert(newRole);

        assertNotEquals(0,id);
        Role insertedRole = (Role)genericDao.getById(id);
        User insertedUser = (User)genericUserDao.getById(id);
        assertEquals(newRole, insertedRole);
        assertEquals(newUser, insertedUser);

    }

    @Test
    void saveOrUpdateUserNameSuccess() {

        String newUserName = "scoobyDoo";

        Role userToUpdate = (Role)genericDao.getByPropertyWithStringUniqueEqual("userName","almfamily");
        userToUpdate.setUserName(newUserName);

        genericDao.saveOrUpdate(userToUpdate);

        Role retrieveUpdatedUser = (Role)genericDao.getByPropertyWithStringUniqueEqual("userName", "scoobyDoo");
        assertEquals(userToUpdate, retrieveUpdatedUser);

    }

}
