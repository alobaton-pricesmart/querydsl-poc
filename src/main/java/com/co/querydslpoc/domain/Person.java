package com.co.querydslpoc.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "person")
@Data
@EqualsAndHashCode(of = {"id"}, doNotUseGetters = true, callSuper = false)
public class Person {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;
  private String name;
  private String lastName;
  private String email;
  private LocalDate birthdate;
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "user_car", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "plate"))
  private List<Car> carList;
}
