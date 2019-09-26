package com.joealexanderIII.dao;

import com.joealexanderIII.model.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

/**
 * The DAO for the Role class
 */
public class RoleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets role for user.
     *
     * @param userName the user name
     * @return the role for user
     */
    public Role getRoleForUser(String userName) {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        Expression<String> propertyPath = root.get("userName");
        query.where(builder.equal(propertyPath, userName));
        Role userRole = session.createQuery(query).getSingleResult();

        // Log an info message
        logger.debug("Searching for user name: { } ", userName);

        session.close();
        return userRole;

    }

    public int insert(Role role) {

        int id;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(role);
        transaction.commit();
        session.close();
        return id;

    }
}
