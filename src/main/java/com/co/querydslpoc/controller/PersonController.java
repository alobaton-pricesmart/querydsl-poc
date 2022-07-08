package com.co.querydslpoc.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.querydslpoc.domain.Person;
import com.co.querydslpoc.dto.PersonDto;
import com.co.querydslpoc.mapper.PersonMapper;
import com.co.querydslpoc.service.PersonService;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService service;

  @Autowired
  private PersonMapper mapper;

  @GetMapping("/paged")
  public Page<PersonDto> getAll(
      @QuerydslPredicate(root = Person.class) Predicate predicate,
      Pageable pageable) {
    Page<Person> page = service.getAll(predicate, pageable);

    return new PageImpl<>(page.getContent().stream().map(mapper::toDto).collect(
        Collectors.<PersonDto>toList()), pageable, page.getTotalElements());
  }

  @PostMapping
  public PersonDto create(@RequestBody PersonDto dto) {
    return mapper.toDto(service.create(mapper.toDomain(dto)));
  }
}
