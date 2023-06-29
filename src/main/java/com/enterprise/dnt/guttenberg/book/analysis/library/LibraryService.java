package com.enterprise.dnt.guttenberg.book.analysis.library;

import com.enterprise.dnt.guttenberg.book.analysis.book.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;

//import static org.junit.Assert.assertEquals;

//import j
//@Slf4J
@Component
public class LibraryService {
//    Map<Book>
  private final String connectionString = "https://gutendex.com";
//  Logger
//  private final WebClient webClient;
  public List<Book> getBookByLanguage(String language) {
    return null;
  }

  public List<Book> getBookByAuthor(int start, int end){
    return null;
  }


  public Book getBook(String id) throws IOException {
    String connectionString = "https://gutendex.com/";
    WebClient client = WebClient.builder()
        .baseUrl(connectionString)
        .build();

    String response =
        client
            .get()
            .uri("/books/{id}/", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchangeToMono(clientResponse -> {
              if (clientResponse.statusCode().is4xxClientError() || clientResponse.statusCode().is5xxServerError()) {
                return clientResponse.createError();
              }
              else {
                return clientResponse.bodyToMono(String.class);
              }
            }).block();
    ObjectMapper objectMapper = new ObjectMapper();
    Book book = objectMapper.readValue(response, Book.class);

    return book;
  }

}
