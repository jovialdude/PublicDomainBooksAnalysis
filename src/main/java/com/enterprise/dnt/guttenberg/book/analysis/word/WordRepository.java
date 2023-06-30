package com.enterprise.dnt.guttenberg.book.analysis.word;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordRepository implements WordDAO {
  private EntityManager entityManager;

  @Autowired
  public WordRepository(EntityManager entityManager) {
    this.entityManager=entityManager;
  }

  @Override
  @Transactional
  public void save(Word word) {
    entityManager.persist(word);
  }

  @Override
  @Transactional
  public void save(List<Word> word) {}
}
