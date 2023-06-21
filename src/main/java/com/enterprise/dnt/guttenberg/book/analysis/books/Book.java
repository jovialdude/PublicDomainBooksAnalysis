package com.enterprise.dnt.guttenberg.book.analysis.books;

import org.springframework.stereotype.Component;

import java.util.Map;

//@Component
public record Book(String name, String ISBN, Map<String, Integer> map) {
}
