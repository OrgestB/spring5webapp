package guru.bootstrap;

import guru.domian.Author;
import guru.domian.Book;
import guru.repositoties.AuthorRepository;
import guru.repositoties.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    Author eric = new Author('Eric', 'Evans');
    Book book1 = new Book('Domain Driver Design', '123123');
    eric.getBooks().add(book1);
    book1.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(book1);
}
