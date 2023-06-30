package com.enterprise.dnt.guttenberg.book.analysis.book;

import com.enterprise.dnt.guttenberg.book.analysis.word.Word;
import com.enterprise.dnt.guttenberg.book.analysis.word.WordRepository;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@Component
public class BookAnalyzeService {

  Map<String, Integer> wordMap;
  WordRepository wordRepository;

  @Autowired
  public BookAnalyzeService(WordRepository wordRepository){
    wordMap = new TreeMap<>();
    this.wordRepository = wordRepository;
  }

  public Element analyze(Book book, String connectionString) throws IOException {
    return analyze(connectionString);
  }

  public Element analyze(String connectionString) throws IOException {
    try {
      //tag #root/html/body?header/div
      Document doc = Jsoup.connect(connectionString).get();
      Elements chapters = doc.body().getElementsByClass("chapter");

      for (Element e: chapters) {
        analyzeChapter(e);
      }

      return null;
    }
    catch (HttpStatusException e) {
      System.out.println(e);
    }
    return null;
  }

  public void analyzeChapter(Element chapter) {
    Elements paragraphs = chapter.select("p");
    for (Element q: paragraphs) {
      //paragraph are pure information
      if(q.attributes()==null) {
//        System.out.println(q.data());
        String[] splitSentence = q.data().split(" ");
        for (String s: splitSentence) {
          int temp = wordMap.getOrDefault(s, 0);
          wordMap.put(s, ++temp);
        }
      }
    }
  }

  public void saveAnalysis() {
    List<Word> list = new ArrayList<>();

    for (String s : wordMap.keySet()) {
      list.add(new Word(s, wordMap.get(s)));
    }
    wordRepository.save(list);
  }
//  public void
}
