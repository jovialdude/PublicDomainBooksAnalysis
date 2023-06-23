package com.enterprise.dnt.guttenberg.book.analysis.controllers;

import com.enterprise.dnt.guttenberg.book.analysis.book.Book;
import com.enterprise.dnt.guttenberg.book.analysis.library.libraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class libraryController {
  private libraryService l;

  @GetMapping("/book/{id}")
  public Book getBook(@Autowired libraryService lib, @PathVariable String id) throws IOException {
    this.l = lib;
    return l.getBook(id);
  }
}
