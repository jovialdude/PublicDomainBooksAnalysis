package com.enterprise.dnt.guttenberg.book.analysis.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORD_COUNT")
public class Word {
  @Id
  @Column(name = "word", nullable = false)
  private String word;

  @Column(name = "count")
  private Integer count;

  public Word(){}

  public Word(String word, Integer count) {
    this.word = word;
    this.count = count;
  }

  public String getId() {
    return word;
  }

  public void setId(String id) {
    this.word = id;
  }

  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "Word{" +
        "id='" + word + '\'' +
        ", count=" + count +
        '}';
  }
}