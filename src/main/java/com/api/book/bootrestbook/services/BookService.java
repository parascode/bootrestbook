package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

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

    public Book getBook(int id) {
        Book book = null;
        book = bookList.stream().filter(b -> b.getId() == id).findFirst().get();
        return book;
    }
}
