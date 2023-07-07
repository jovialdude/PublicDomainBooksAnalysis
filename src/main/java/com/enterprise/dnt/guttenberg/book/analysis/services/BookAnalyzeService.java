package com.enterprise.dnt.guttenberg.book.analysis.services;

import com.enterprise.dnt.guttenberg.book.analysis.pojo.Book;
import com.enterprise.dnt.guttenberg.book.analysis.repository.WordRepository;
import com.enterprise.dnt.guttenberg.book.analysis.pojo.Word;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class BookAnalyzeService {

  private WordRepository wordRepository;
  private static final Logger logger = LoggerFactory.getLogger(BookAnalyzeService.class);

  @Autowired
  public BookAnalyzeService(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  public Element analyze(Book book, String connectionString) throws IOException {
    return analyze(connectionString);
  }

  public Element analyze(String connectionString) throws IOException {
    try {
      logger.atInfo().log("Starting analysis process");
      //tag #root/html/body?header/div
      Document doc = Jsoup.connect(connectionString).get();
      Elements pagraphs = doc.body().getElementsByClass("chapter").select("p");
      int count = 0;

      for (Element e : pagraphs) {
        analyzeParagraph(e);
      }

      return null;
    } catch (HttpStatusException e) {
      System.out.println(e);
    }
    logger.atInfo().log("Finished analysis process");
    return null;
  }

  public void analyzeParagraph(Element paragraph) {
    for (Node e : paragraph.childNodes()) {
      Map<String, Integer> tempMap = new HashMap<>();
      String[] splitSentence = e.toString().split(" ");
      for (String s : splitSentence) {
        int temp = tempMap.getOrDefault(s, 0);
        tempMap.put(s, ++temp);
      }
      saveAnalysis(tempMap);
    }
  }

  public void saveAnalysis(Map<String, Integer> map) {
    List<Word> list = new ArrayList<>();
    logger.atInfo().log("Saving to DB");
    for (String s : map.keySet()) {
      list.add(new Word(s, map.get(s)));
    }
    logger.atInfo().log("\\tNumber of record saved " + list.size() );
    wordRepository.save(list);
//    logger.atInfo().log("Starting analysis process");
  }
//  public void
}
