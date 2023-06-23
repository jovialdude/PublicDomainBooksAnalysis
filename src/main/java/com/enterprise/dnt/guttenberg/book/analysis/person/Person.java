package com.enterprise.dnt.guttenberg.book.analysis.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Person implements Serializable {
  @JsonProperty("name")
  String name;
  @JsonProperty("birth_year")
  int birth_year;
  @JsonProperty("death_year")
  int death_year;

  public Person(){}


  public Person(String name, int birth_year, int death_year) {
    this.birth_year = birth_year;
    this.death_year = death_year;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBirth_year() {
    return birth_year;
  }

  public void setBirth_year(int birth_year) {
    this.birth_year = birth_year;
  }

  public int getDeath_year() {
    return death_year;
  }

  public void setDeath_year(int death_year) {
    this.death_year = death_year;
  }
}
