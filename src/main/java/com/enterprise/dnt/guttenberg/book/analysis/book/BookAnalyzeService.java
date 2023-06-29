package com.enterprise.dnt.guttenberg.book.analysis.book;

import ch.qos.logback.classic.Logger;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


@Component
public class BookAnalyzeService {
  Map<String, Integer> wordMap = new TreeMap<>();
//  Logger log = new Log
//  private static final Logger log = LoggerFactory.getLogger(BookAnalyzeService.class);
  public BookAnalyzeService(){}
  public Document analyze(Book book) throws IOException {
    String connectionString = book.getFormats().get("text/html");

    try {
      Document doc = Jsoup.connect(connectionString).get();
      return doc;
    }
    catch (HttpStatusException e) {
      System.out.println(e);
    }
    return null;
  }
}
