package com.co.querydslpoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.co.querydslpoc.domain.Person;
import com.co.querydslpoc.repository.PersonRepository;
import com.querydsl.core.types.Predicate;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository repository;

  @Override
  public Page<Person> getAll(Predicate predicate, Pageable pageable) {
    return repository.findAll(predicate, pageable);
  }

  @Override
  public Person create(Person person) {
    return repository.save(person);
  }

}
