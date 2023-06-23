package com.enterprise.dnt.guttenberg.book.analysis.book;

import com.enterprise.dnt.guttenberg.book.analysis.person.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;


@Component
public class Book implements Serializable {
  @JsonProperty("id")
  private int id;
  @JsonProperty("title")
  private String title;
  @JsonProperty("subjects")
  private String[] subjects;
  @JsonProperty("authors")
  private Person[] authors;
  @JsonProperty("translators")
  private Person[] translators;
  @JsonProperty("bookshelves")
  private String[] bookshelves;
  @JsonProperty("languages")
  private String[] languages;
  @JsonProperty("copyright")
  private boolean copyright;
  @JsonProperty("media_type")
  private String mediaType;
  @JsonProperty("formats")
  private Map<String, String> formats;
  @JsonProperty("download_count")
  private int downloadCount;

  public Book(){}

  public Book(int id, String title, String[] subjects, Person[] authors,
              Person[] translators, String[] bookshelves, String[] languages,
              boolean copyright, String mediaType, Map<String, String> formats, int downloadCount) {
    this.id = id;
    this.title = title;
    this.subjects = subjects;
    this.authors = authors;
    this.translators = translators;
    this.bookshelves = bookshelves;
    this.languages = languages;
    this.copyright = copyright;
    this.mediaType = mediaType;
    this.formats = formats;
    this.downloadCount = downloadCount;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String[] getSubjects() {
    return subjects;
  }

  public void setSubjects(String[] subjects) {
    this.subjects = subjects;
  }

  public Person[] getAuthors() {
    return authors;
  }

  public void setAuthors(Person[] authors) {
    this.authors = authors;
  }

  public Person[] getTranslators() {
    return translators;
  }

  public void setTranslators(Person[] translators) {
    this.translators = translators;
  }

  public String[] getBookshelves() {
    return bookshelves;
  }

  public void setBookshelves(String[] bookshelves) {
    this.bookshelves = bookshelves;
  }

  public String[] getLanguages() {
    return languages;
  }

  public void setLanguages(String[] languages) {
    this.languages = languages;
  }

  public boolean isCopyright() {
    return copyright;
  }

  public void setCopyright(boolean copyright) {
    this.copyright = copyright;
  }

  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public Map<String, String> getFormats() {
    return formats;
  }

  public void setFormats(Map<String, String> formats) {
    this.formats = formats;
  }

  public int getDownloadCount() {
    return downloadCount;
  }

  public void setDownloadCount(int number) {
    this.downloadCount = number;
  }
}
