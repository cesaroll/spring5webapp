/*
 * @author Cesar Lopez Lerma
 * @copyright 2021 All rights reserved
 */

package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) {

        Publisher publisher = new Publisher("GOT Pubish Co", "Main Str. 1", "The Citadel", "Oldtown", "12000");

        publisherRepository.save(publisher);

        Author john = new Author("John", "Snow");
        Book book = new Book("The North Remembers", "21323432434");
        john.getBooks().add(book);
        book.getAuthors().add(john);
        book.setPublisher(publisher);

        authorRepository.save(john);
        bookRepository.save(book);

        Author dany = new Author("Dany", "Targarien");
        Book danyBook = new Book("Riding Dragons", "3254565767");
        dany.getBooks().add(danyBook);
        danyBook.getAuthors().add(dany);
        danyBook.setPublisher(publisher);

        authorRepository.save(dany);
        bookRepository.save(danyBook);

        System.out.println("Started in Bootstrap");
        System.out.println("number of Authors: " + authorRepository.count());
        System.out.println("number of Books: " + bookRepository.count());
        System.out.println("number of Publishers: " + publisherRepository.count());
    }
}
