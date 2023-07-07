package com.enterprise.dnt.guttenberg.book.analysis.intefaces.dao;

import com.enterprise.dnt.guttenberg.book.analysis.pojo.Word;

import java.util.List;

public interface WordDAO {
  public void save(Word word);
  public void save(List<Word> word);
}
