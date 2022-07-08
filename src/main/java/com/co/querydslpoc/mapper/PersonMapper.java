package com.co.querydslpoc.mapper;

import org.mapstruct.Mapper;

import com.co.querydslpoc.domain.Person;
import com.co.querydslpoc.dto.PersonDto;

@Mapper
public interface PersonMapper {
  Person toDomain(PersonDto dto);
  PersonDto toDto(Person domain);
}
