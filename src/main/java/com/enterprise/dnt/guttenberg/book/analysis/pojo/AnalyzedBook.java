package com.enterprise.dnt.guttenberg.book.analysis.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Map;

@Entity
@Table(name="book")
public class AnalyzedBook {
  @Id
  @Column(name="id", nullable = false)
  private Integer id;

  @Column(name="ISBN")
  private String ISBN;

  @Column(name="completedStatus")
  private String completeStatus ;

  public AnalyzedBook() {
  }

  public AnalyzedBook(Integer id, String ISBN, Map<String, Integer> wordMap) {
    this.id = id;
    this.ISBN = ISBN;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

}
