package com.joealexanderIII.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * A Generic Dao that will accept any type
 *
 * @param <T> the type parameter
 */
public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the entity type, for example, User.
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all entities
     *
     * @return all the entities
     */
    public List<T> getAll() {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> entities = session.createQuery(query).getResultList();

        // Log an info message
        logger.info("All entities retrieved");

        session.close();
        return entities;

    }

    /**
     * Get entity by property (exact match) and only one matches
     *
     * @param propertyName entity property to search by
     * @param value        object value of the property to search for
     * @return list of entities meeting the criteria search
     */
    public T getByPropertyUniqueEqual(String propertyName, Object value) {

        Session session = getSession();

        logger.debug("Searching for entity with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from(type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        T entity = session.createQuery( query ).getSingleResult();

        session.close();
        return entity;

    }

    /**
     * Get entity by property (exact match with multiple matches)
     *
     * @param propertyName entity property to search by
     * @param value        value of the property to search for
     * @return list of entities meeting the criteria search
     */
    public List<T> getByPropertyListEqual(String propertyName, String value) {

        Session session = getSession();

        logger.debug("Searching for entity with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from(type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery( query ).getResultList();

        session.close();
        return entities;

    }

    /**
     * Get entity by property (like)
     *
     * @param propertyName entity property to search by
     * @param value        value of the property to search for
     * @return list of entities meeting the criteria search
     */
    public List<T> getByPropertyLike(String propertyName, String value) {

        Session session = getSession();

        logger.debug("Searching for entity with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from(type );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entities = session.createQuery( query ).getResultList();

        session.close();
        return entities;

    }


    /**
     * Insert new entity
     *
     * @param entity Order to be inserted or updated
     * @return id of the inserted entity
     */
    public int insert(T entity) {

        int id = 0;
        Session session = getSession();

        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();

        return id;

    }

    /**
     * Gets a entity by id
     *
     * @param <T> the type parameter
     * @param id  entity id to search by
     * @return a entity
     */
    public <T>T getById(int id) {

        Session session = getSession();

        T entity = (T)session.get(type, id);

        session.close();
        return entity;

    }

    /**
     * update entity
     *
     * @param entity the entity type to be inserted or updated
     */
    public void saveOrUpdate(T entity) {

        Session session = getSession();

        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();

        session.close();

    }

    /**
     * Deletes the entity.
     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {

        Session session = getSession();

        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();

        session.close();
    }

    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}

