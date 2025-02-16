package com.MyFirstSpringProject.VBookstore.Service;

import com.MyFirstSpringProject.VBookstore.Model.Book;

import java.math.BigDecimal;
import java.util.List;

public interface IBookService {
    // Getting all books
    List<Book> getAllBooks();

    // Search for books
    List<Book> searchBooks(String name, String author, Integer minYear, Integer maxYear, BigDecimal minPrice, BigDecimal maxPrice, BigDecimal minRating, BigDecimal maxRating);
}