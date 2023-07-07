package com.enterprise.dnt.guttenberg.book.analysis;

import com.enterprise.dnt.guttenberg.book.analysis.pojo.Book;
import com.enterprise.dnt.guttenberg.book.analysis.services.BookAnalyzeService;
import com.enterprise.dnt.guttenberg.book.analysis.services.LibraryService;
import com.enterprise.dnt.guttenberg.book.analysis.pojo.Word;
import com.enterprise.dnt.guttenberg.book.analysis.intefaces.dao.WordDAO;
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
//			analyzeBook(bookAnalyzeService, libraryService);
		};
	}

	public void analyzeBook(BookAnalyzeService bookAnalyzeService,
													LibraryService libraryService) throws IOException {
		Book b = libraryService.getBook("2600");
		System.out.println("Got Book");
		String formatConnectionString = b.getFormats().get("text/html");
		System.out.println(formatConnectionString);
		System.out.println("Got Format");
		bookAnalyzeService.analyze(formatConnectionString);
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
