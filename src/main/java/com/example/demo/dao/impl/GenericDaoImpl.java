package com.example.demo.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.websocket.Session;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.dao.GenericDao;

public class GenericDaoImpl implements GenericDao {

    @Autowired
    EntityManager entityManager;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    
    public <T> T getById(Class<T> type, Serializable id){
        return entityManager.find(type, id);
    }

    @Override
    public <T> List<T> getByIds(Class<T> type, Serializable... ids) {
        return null;
    }

    @Override
    public <T> List<T> query(Class<T> type, Specification<T> spec) {
        // sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(type.getClass());
        // entityManager.unwrap(Session.class).createCriteria()
        
        // Criteria criteria = new Criteria() {
            
        // }; 
        // entityManager.createQuery()
        return null;
    }
}
