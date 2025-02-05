package com.MyFirstSpringProject.VBookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService implements IBookService {

    private final IBookRepository IBookRepository;

    @Autowired
    public BookService(IBookRepository IBookRepository) {
        this.IBookRepository = IBookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return IBookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String name, String author, Integer minYear, Integer maxYear, BigDecimal minPrice, BigDecimal maxPrice) {
        return IBookRepository.findByCriteria(name, author, minYear, maxYear, minPrice, maxPrice);
    }
}