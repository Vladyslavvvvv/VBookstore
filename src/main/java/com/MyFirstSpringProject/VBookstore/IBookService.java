package com.MyFirstSpringProject.VBookstore;

import java.math.BigDecimal;
import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    List<Book> searchBooks(String name, String author, Integer minYear, Integer maxYear, BigDecimal minPrice, BigDecimal maxPrice, BigDecimal minRating, BigDecimal maxRating);
}