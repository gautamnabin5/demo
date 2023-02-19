package com.example.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

public interface GenericDao {
    <T> T getById(Class<T> type, Serializable id);

    <T> List<T> getByIds(Class<T> type, Serializable... ids);

    <T> List<T> query(Class<T> type, Specification<T> spec);
}
