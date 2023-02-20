package com.example.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GenericDao {
    <T> T getById(Class<T> type, Serializable id);

    <T> List<T> getByIds(Class<T> type, Serializable... ids);

    <T> List<T> getByIdUsingCriteria(Class<T> type, int id);
}
