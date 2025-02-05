package com.MyFirstSpringProject.VBookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {
    // Query to search for books by parameters
    @Query("SELECT b FROM Book b WHERE " +
            "(:name is null or b.name like %:name%) and " +
            "(:author is null or b.author like %:author%) and " +
            "(:minYear is null or b.year >= :minYear) and " +
            "(:maxYear is null or b.year <= :maxYear) and " +
            "(:minPrice is null or b.price >= :minPrice) and " +
            "(:maxPrice is null or b.price <= :maxPrice)")
    List<Book> findByCriteria(@Param("name") String name,
                              @Param("author") String author,
                              @Param("minYear") Integer minYear,
                              @Param("maxYear") Integer maxYear,
                              @Param("minPrice") BigDecimal minPrice,
                              @Param("maxPrice") BigDecimal maxPrice);
}