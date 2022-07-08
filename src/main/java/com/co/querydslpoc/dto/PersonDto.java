package com.co.querydslpoc.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PersonDto {
  private String id;
  private String name;
  private String lastName;
  private String email;
  private LocalDate birthdate;
  private List<CarDto> carList;
}
