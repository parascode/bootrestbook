package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

    public static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(12, "Java", "abc"));
        bookList.add(new Book(45, "Python", "xyz"));
        bookList.add(new Book(89, "JavaScript", "ijk"));
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getBookById(int id) {
        Book book = null;
        try {
            book = bookList.stream().filter(b -> b.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b) {
        bookList.add(b);
        return b;
    }

    public void deleteBook(int bid) {
        bookList = bookList.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
    }

    public void updateBook(Book bookNew, int bid) {
        bookList = bookList.stream().map(book -> {
            if (book.getId() == bid)
                return bookNew;
            return book;
        }).collect(Collectors.toList());
    }
}
