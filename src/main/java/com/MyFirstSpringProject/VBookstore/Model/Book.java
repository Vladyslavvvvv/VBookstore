package com.MyFirstSpringProject.VBookstore.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idbook")
    private Long idbook;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "year")
    private int year;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "rating")
    private BigDecimal rating;

    public Long getIdbook() {
        return idbook;
    }
    public void setIdbook(Long idbook) {
        this.idbook = idbook;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRating() {
        return rating;
    }
    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book: id = " + idbook + ", name = '" + name + "', author = " + author + ", year = " + year + ", price = " + price;
    }
}
