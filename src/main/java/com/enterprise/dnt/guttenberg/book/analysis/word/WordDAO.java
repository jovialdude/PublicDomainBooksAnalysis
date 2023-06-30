package com.enterprise.dnt.guttenberg.book.analysis.word;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordDAO {
  public void save(Word word);
  public void save(List<Word> word);
}
