package com.co.querydslpoc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "car")
@Data
@EqualsAndHashCode(of = { "plate" }, doNotUseGetters = true, callSuper = false)
public class Car {
  @Id
  private String plate;
  private String model;
}
