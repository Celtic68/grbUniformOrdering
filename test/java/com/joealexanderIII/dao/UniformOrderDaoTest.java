package com.joealexanderIII.dao;

import com.joealexanderIII.model.Player;
import com.joealexanderIII.model.UniformOrder;
import com.joealexanderIII.util.Database;
import org.junit.jupiter.api.BeforeEach;

public class UniformOrderDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(UniformOrder.class);

        Database database = Database.getInstance();
        database.runSQL("cleanTestDB.sql");

    }

}
