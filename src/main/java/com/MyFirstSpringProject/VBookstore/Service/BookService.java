package com.MyFirstSpringProject.VBookstore.Service;

import com.MyFirstSpringProject.VBookstore.Model.Book;
import com.MyFirstSpringProject.VBookstore.Model.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService implements IBookService {

    private final com.MyFirstSpringProject.VBookstore.Model.IBookRepository IBookRepository;

    @Autowired
    public BookService(IBookRepository IBookRepository) {
        this.IBookRepository = IBookRepository;
    }

    // Getting all books
    @Override
    public List<Book> getAllBooks() {
        return IBookRepository.findAll();
    }

    // Search for books
    @Override
    public List<Book> searchBooks(String name, String author, Integer minYear, Integer maxYear, BigDecimal minPrice, BigDecimal maxPrice, BigDecimal minRating, BigDecimal maxRating) {
        return IBookRepository.findByParameters(name, author, minYear, maxYear, minPrice, maxPrice, minRating, maxRating);
    }
}