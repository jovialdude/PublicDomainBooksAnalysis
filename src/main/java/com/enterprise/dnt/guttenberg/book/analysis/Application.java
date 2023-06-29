package com.enterprise.dnt.guttenberg.book.analysis;

import com.enterprise.dnt.guttenberg.book.analysis.word.Word;
import com.enterprise.dnt.guttenberg.book.analysis.word.WordDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(WordDAO wordDAO) {
		return runner-> {
//			saveWord(wordDAO);
			System.out.println("LOLOLOL");
		};
	}

	public void saveWord(WordDAO wordDao) {
		Word w = new Word("Hello", 10);
		System.out.println("Saving Hello");
		wordDao.save(w);
		System.out.println("Word" + w);
		System.out.println("Done Saving Hello");
	}
}
