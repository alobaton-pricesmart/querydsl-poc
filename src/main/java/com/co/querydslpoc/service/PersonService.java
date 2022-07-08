package com.co.querydslpoc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.co.querydslpoc.domain.Person;
import com.querydsl.core.types.Predicate;

public interface PersonService {

  Page<Person> getAll(Predicate predicate, Pageable pageable);
  
  Person create(Person person);
}
