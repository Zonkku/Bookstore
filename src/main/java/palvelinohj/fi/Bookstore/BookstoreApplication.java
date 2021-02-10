package palvelinohj.fi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import palvelinohj.fi.Bookstore.domain.Book;
import palvelinohj.fi.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
			return (args) -> {
				Book b1 = new Book("Soturikissat", "Erin Hunter", "9789510450949", 2021, 19.9);
				Book b2 = new Book("Kissasoturit", "Erika Huntington", "9789510450948", 2020, 18.8);
				Book b3 = new Book("Sotekissat", "Erian Terhun", "9789510450947", 2019, 17.7);
				
				repository.save(b1);
				repository.save(b2);
				repository.save(b3);
				
				for (Book book : repository.findAll()) {
					System.out.println(book.toString());
				}
			};
		
	}
}
