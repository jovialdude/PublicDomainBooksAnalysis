package com.enterprise.dnt.guttenberg.book.test.services;

import com.enterprise.dnt.guttenberg.book.analysis.pojo.Book;
import com.enterprise.dnt.guttenberg.book.analysis.services.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LibraryServiceTest {
  private static final Logger logger = LoggerFactory.getLogger(LibraryServiceTest.class);

  LibraryService libraryService;
  ClassLoader classLoader;

  {
    libraryService=new LibraryService();
    classLoader=getClass().getClassLoader();
  }

  @Test
  public void testBookRertrievalByIdSuccess() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    byte[] jsonByte = classLoader.getResourceAsStream("JSONs/Book2600.json").readAllBytes();
    Book testBook = objectMapper.readValue(jsonByte, Book.class);
    Book actualBook = libraryService.getBook("2600");

    Assert.assertEquals(objectMapper.writeValueAsString(testBook),
        objectMapper.writeValueAsString(actualBook));

    jsonByte = classLoader.getResourceAsStream("JSONs/Book2650.json").readAllBytes();
    testBook = objectMapper.readValue(jsonByte, Book.class);
    actualBook = libraryService.getBook("2650");
    Assert.assertEquals(objectMapper.writeValueAsString(testBook),
        objectMapper.writeValueAsString(actualBook));

    jsonByte = classLoader.getResourceAsStream("JSONs/Book2700.json").readAllBytes();
    testBook = objectMapper.readValue(jsonByte, Book.class);
    actualBook = libraryService.getBook("2700");
    Assert.assertEquals(objectMapper.writeValueAsString(testBook),
        objectMapper.writeValueAsString(actualBook));
  }

//  @Test?
}
