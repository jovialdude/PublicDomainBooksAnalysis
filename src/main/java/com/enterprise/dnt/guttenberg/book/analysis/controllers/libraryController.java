package com.enterprise.dnt.guttenberg.book.analysis.controllers;

import com.enterprise.dnt.guttenberg.book.analysis.library.Library;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class libraryController {
  @GetMapping("/book/{id}")
  public String getBook(@PathVariable String id) throws IOException {
    System.out.println(id);
    Library l = new Library();
    return l.getBook(id);
  }


}
