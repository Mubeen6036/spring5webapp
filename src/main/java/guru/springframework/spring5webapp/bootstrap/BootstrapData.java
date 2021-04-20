package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Desing", "12");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        Author rod = new Author("John", "Snow");
        Book got = new Book("Game Of Thrones", "11");
        rod.getBooks().add(got);
        got.getAuthors().add(rod);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        System.out.println("Started in Bootstrap");
        System.out.println("Number Of Books"+bookRepository.count());

    }
}
