package com.enterprise.dnt.guttenberg.book.analysis.book;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnalyzedBookRepository implements AnalyzedBookDAO {
  private EntityManager entityManager;

  @Autowired
  public AnalyzedBookRepository(EntityManager entityManager){
    this.entityManager=entityManager;
  }

  @Override
  @Transactional
  public void save(AnalyzedBook analyzedBook) {
    entityManager.persist(analyzedBook);
  }
}
