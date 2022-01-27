package com.coy.sect2.bootstrap;

import com.coy.sect2.domain.Author;
import com.coy.sect2.domain.Book;
import com.coy.sect2.domain.Publisher;
import com.coy.sect2.repositories.AuthorRepository;
import com.coy.sect2.repositories.BookRepository;
import com.coy.sect2.repositories.PublisherRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BootstrapData implements CommandLineRunner {
    final AuthorRepository authorRepository;
    final BookRepository bookRepository;
    final PublisherRepository publisherRepository;

    @Autowired
    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evens");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book j2ee = new Book("JE22 Development without EJB", "3939459459");
        rod.getBooks().add(j2ee);
        j2ee.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(j2ee);

        Publisher publisher = new Publisher("Fox Publishing House", "111 Main Street", "New York City", "NY", "21212");
        publisher.getBooks().add(ddd);
        publisher.getBooks().add(j2ee);
        publisherRepository.save(publisher);

        log.info("fxh: started in Bootstrap");
        log.info("fxh: number of books: {}", bookRepository.count());
        log.info("fxh: publisher book count: {}", publisher.getBooks().size());
    }
}
