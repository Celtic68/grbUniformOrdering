package com.joealexanderIII.dao;


import com.joealexanderIII.model.Role;
import com.joealexanderIII.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Role dao test.
 */
public class RoleDaoTest {

    /**
     * The Role dao.
     */
    RoleDao roleDao;

    /**
     * Creating the Dao.
     */
    @BeforeEach
    void setUp() {

        roleDao = new RoleDao();

        Database database = Database.getInstance();
        database.runSQL("cleanTestDB.sql");
    }

    /**
     * Gets admin role for user success.
     */
    @Test
    void getAdminRoleForUserSuccess() {

        Role userRole = roleDao.getRoleForUser("almfamily");
        assertEquals("admin", userRole.getUserRole());
    }

    /**
     * Gets user role for user success.
     */
    @Test
    void getUserRoleForUserSuccess() {

        Role userRole = roleDao.getRoleForUser("jleitl");
        assertEquals("user", userRole.getUserRole());
    }

    @Test
    void insert() {

        Role newRole = new Role("bevans","user");
        int id = roleDao.insert(newRole);
        assertNotEquals(0,id);
        Role insertedRole = roleDao.getRoleForUser(newRole.getUserName());
        assertEquals("user", insertedRole.getUserRole());
        assertEquals("bevans", insertedRole.getUserName());
    }
}
