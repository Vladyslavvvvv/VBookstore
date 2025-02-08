package com.MyFirstSpringProject.VBookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class BookController {

    private final IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/search")
    public String searchBooks(
            // Getting search parameters from a page
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "minYear", required = false) Integer minYear,
            @RequestParam(value = "maxYear", required = false) Integer maxYear,
            @RequestParam(value = "minPrice", required = false) BigDecimal minPrice,
            @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice,
            @RequestParam(value = "minRating", required = false) BigDecimal minRating,
            @RequestParam(value = "maxRating", required = false) BigDecimal maxRating,
            Model model) {

        // Calling the method for searching by the received parameters
        // And recording the found books in the list
        List<Book> books = bookService.searchBooks(name, author, minYear, maxYear, minPrice, maxPrice, minRating, maxRating);

        // Saving the specified parameters for display in the fields
        // So that you don't have to re-enter them every time
        model.addAttribute("books", books);
        model.addAttribute("name", name);
        model.addAttribute("author", author);
        model.addAttribute("minYear", minYear);
        model.addAttribute("maxYear", maxYear);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("minRating", minRating);
        model.addAttribute("maxRating", maxRating);

        return "books";
    }
}