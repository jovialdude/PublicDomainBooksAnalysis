package com.enterprise.dnt.guttenberg.book.test.controllers;


import com.enterprise.dnt.guttenberg.book.analysis.pojo.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ExtendWith(MockitoExtension.class)
public class LibraryControllerTest {
  @Test
  public void testOkRequestForSingleBook() throws IOException {
    byte[] jsonByte = Files.readAllBytes(Paths.get("Book2600.json"));
    ObjectMapper objectMapper = new ObjectMapper();
    Book book = objectMapper.readValue(jsonByte, Book.class);
//    objectMapper.readTree

//    Assert
  }

}
