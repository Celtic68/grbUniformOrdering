package com.joealexanderIII.dao;

import com.joealexanderIII.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();

        // Log an info message
        logger.info("All users retrieved");

        session.close();
        return users;

    }

    public User getUserByUserName(String userName) {

        logger.debug("Searching for: {}", userName);
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("userName");
        query.where(builder.equal(propertyPath, userName));
        User retrievedUser = session.createQuery(query).getSingleResult();

        // Log an info message
        logger.info("Searched for a specific user: { }", userName);

        session.close();
        return retrievedUser;

    }

    /**
     * Gets a user by ID.
     *
     * @return the specific user
     */
    public User getUserById(int id) {

        Session session = sessionFactory.openSession();

        User user = session.get(User.class, id);

        session.close();
        return user;

    }

    /**
     * Gets search criteria users.
     *
     * @return the search criteria users
     */
    public List<User> getSearchCriteriaUsers(String searchCriteria, String searchField) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get(searchField);
        query.where(builder.like(propertyPath, "%" + searchCriteria + "%"));
        List<User> users = session.createQuery(query).getResultList();

        // Log an info message
        logger.info("Search Criteria is: {} for the {} field", searchCriteria, searchField);

        session.close();
        return users;

    }

    /**
     * update user
     * @param user  User to be inserted or updated
     */
    public void saveOrUpdate(User user) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();

    }

    /**
     * Insert a user
     * @param user  User to be inserted or updated
     */
    public int insert(User user) {

        int id;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;

    }

    /**
     * Delete a user
     * @param user User to be deleted
     */
    public void delete(User user) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();

    }
}
