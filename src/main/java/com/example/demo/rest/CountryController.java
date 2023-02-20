package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GenericDao;
import com.example.demo.entity.Country;

@RestController
@RequestMapping("/country")
public class CountryController {
    
    @Autowired
    GenericDao genericDao;

    @GetMapping("/{id}")
    public List<Country> getById(@PathVariable("id") int id){
        return genericDao.getByIdUsingCriteria(Country.class, id);
    }
}
