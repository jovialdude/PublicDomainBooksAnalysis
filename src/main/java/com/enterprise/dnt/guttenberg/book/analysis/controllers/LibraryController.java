package com.enterprise.dnt.guttenberg.book.analysis.controllers;

import com.enterprise.dnt.guttenberg.book.analysis.pojo.Book;
import com.enterprise.dnt.guttenberg.book.analysis.services.BookAnalyzeService;
import com.enterprise.dnt.guttenberg.book.analysis.services.LibraryService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class LibraryController {
  private LibraryService libraryService;
  private BookAnalyzeService bookAnalyzeService;


  @Autowired
  public LibraryController(LibraryService l, BookAnalyzeService b) {
    this.libraryService=l;
    this.bookAnalyzeService=b;
  }

  @GetMapping("/book/{id}")
  public Book getBook(@PathVariable String id) throws IOException {
    return libraryService.getBook(id);
  }

  @GetMapping("/book/analysis")
  public Document getAnalysis(@RequestParam(name="id") String id) throws IOException {
    Book b = libraryService.getBook(id);
//    return bookAnalyzeService.analyze(b);
    return null;
  }

//  @GetMapping("/book/author")

  @GetMapping("/book/author")
  public Integer getBookByYear(@RequestParam(name="start") int start,
                                  @RequestParam(name="end") int end) {
    return start+end;
  }
}
