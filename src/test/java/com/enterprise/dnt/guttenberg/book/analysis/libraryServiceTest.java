package com.enterprise.dnt.guttenberg.book.analysis;

import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

public class libraryServiceTest {
  @Test
  public void testWarAndPeace() {
    WebTestClient testClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
  }
}
