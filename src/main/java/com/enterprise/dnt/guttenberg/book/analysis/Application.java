package com.enterprise.dnt.guttenberg.book.analysis;

import com.enterprise.dnt.guttenberg.book.analysis.book.Book;
import com.enterprise.dnt.guttenberg.book.analysis.book.BookAnalyzeService;
import com.enterprise.dnt.guttenberg.book.analysis.library.LibraryService;
import com.enterprise.dnt.guttenberg.book.analysis.word.Word;
import com.enterprise.dnt.guttenberg.book.analysis.word.WordDAO;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(BookAnalyzeService bookAnalyzeService,
																						 LibraryService libraryService) {
		return runner-> {
//			saveWord(wordDAO);
//			System.out.println("LOLOLOL");
			analyzeBook(bookAnalyzeService, libraryService);
		};
	}

	public void analyzeBook(BookAnalyzeService bookAnalyzeService,
													LibraryService libraryService) throws IOException {
		Book b = libraryService.getBook("2600");
		String format = b.getFormats().get("text/html");

		return;
	}

	public void saveWord(WordDAO wordDao) {
		Word w = new Word("Hello", 10);
		System.out.println("Saving Hello");
		wordDao.save(w);
		System.out.println("Word" + w);
		System.out.println("Done Saving Hello");
	}
}
