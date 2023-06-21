package com.enterprise.dnt.guttenberg.book.analysis.library;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

//import static org.junit.Assert.assertEquals;

//import j
//@Slf4J
@Component
public class Library {
//    Map<Book>

  public Map<String, Integer> analyzeBook() {
    return null;
  }
  //install postgres
  //install pgadmin
  //install guttenberg db

  private final String connectionString = "https://gutendex.com";

  public String getBook(String id) throws IOException {
    WebClient client = WebClient.builder()
        .baseUrl(connectionString)
        .build();

    Mono<String> mono =
        client
            .get()
            .uri("/books/{id}", id).accept(MediaType.APPLICATION_JSON)
            .exchangeToMono(response->{
              if(response.statusCode().equals(HttpStatus.OK)) {
                System.out.println(response.bodyToMono(String.class));
                return response.bodyToMono(String.class);
              }
              else {
                System.out.println(response.createError());
                return response.createError();
              }
            });
//        .retrieve()
//        .bodyToMono(String.class);
//        .block();

//    System.out.println(response.block());
    return null;
  }

}
