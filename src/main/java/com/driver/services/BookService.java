package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.models.Genre;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;
    @Autowired
    private AuthorRepository authorRepository;

    public void createBook(Book book){
        bookRepository2.save(book);

    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = new ArrayList<>();
        if(genre!=null && author!=null){
            return bookRepository2.findBooksByGenreAuthor(genre,author,available);
        }
        else if(genre!=null){
            return bookRepository2.findBooksByGenre(genre,available);
        }
        else if(author!=null){
            return bookRepository2.findBooksByAuthor(author,available);
        }
        else{
            return bookRepository2.findByAvailability(available);
        }

    }
}
