package com.joealexanderIII.dao;


import com.joealexanderIII.model.Role;
import com.joealexanderIII.model.User;
import com.joealexanderIII.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        Role userRole = (Role)genericDao.getByPropertyUniqueEqual("userName","almfamily");
        assertEquals("admin", userRole.getUserRole());
        assertEquals("Joseph", userRole.getUser().getUserFirstName());
    }

    /**
     * Gets user role for user success.
     */
    @Test
    void getUserRoleForUserSuccess() {

        Role userRole = (Role)genericDao.getByPropertyUniqueEqual("userName","jleitl");
        assertEquals("user", userRole.getUserRole());
        assertEquals("Leitl", userRole.getUser().getUserLastName());
    }

    @Test
    void insert() {

        Role newRole = new Role("bevans", "$2y$10$Z0k7T2ZWYJsI8z9WEzH5Bu5lOps/ph7MNNSwgeuJ8rilaTxxz6QBe","user");
        int id = genericDao.insert(newRole);
        assertNotEquals(0,id);
        Role insertedRole = (Role)genericDao.getByPropertyUniqueEqual("userName", newRole.getUserName());
        assertEquals(newRole, insertedRole);

    }

    @Test
    void saveOrUpdateUserNameSuccess() {

        String newUserName = "scoobyDoo";

        Role userToUpdate = (Role)genericDao.getByPropertyUniqueEqual("userName","almfamily");
        userToUpdate.setUserName(newUserName);

        genericDao.saveOrUpdate(userToUpdate);

        Role retrieveUpdatedUser = (Role)genericDao.getByPropertyUniqueEqual("userName", "scoobyDoo");
        assertEquals(userToUpdate, retrieveUpdatedUser);

    }

}
