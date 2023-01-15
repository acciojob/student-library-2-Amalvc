package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;
    @Autowired
    private AuthorRepository authorRepository;

    public void createBook(Book book){
        int id=book.getAuthor().getId();
        Author author=authorRepository.findById(id).get();
        book.setAuthor(author);
        List<Book>list=author.getBooksWritten();
        list.add(book);
        author.setBooksWritten(list);
        authorRepository.save(author);

    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = new ArrayList<>();
        if(author!=null){
            books=bookRepository2.findBooksByAuthor(author,available);
        }
        else if(genre!=null){
            books=bookRepository2.findBooksByGenre(genre,available);
        }
        else if(author!=null && genre!=null){
            books=bookRepository2.findBooksByGenreAuthor(genre,author,available);
        }
        else{
            books=bookRepository2.findByAvailability(available);
        }
        return books;
    }
}