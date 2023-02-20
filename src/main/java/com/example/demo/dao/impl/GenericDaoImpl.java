package com.example.demo.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.GenericDao;

@Component
public class GenericDaoImpl implements GenericDao {

    @Autowired
    EntityManager entityManager;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public <T> T getById(Class<T> type, Serializable id){
        return entityManager.find(type, id);
    }

    @Override
    public <T> List<T> getByIds(Class<T> type, Serializable... ids) {
        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        return sessionFactory.getCurrentSession().byMultipleIds(type).multiLoad(ids);
    }

    @Override
    public <T> List<T> getByIdUsingCriteria(Class<T> type, int id) {
        return (List<T>) entityManager.createQuery("select c from " + type.getName() + " c where c.id = :id;", type)
        .setParameter("id", id)
        .getResultList();
    }
}