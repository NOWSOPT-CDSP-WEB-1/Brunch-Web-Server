package com.brunch.server.book.repository;

import com.brunch.server.book.entity.Book;
import com.brunch.server.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b JOIN Author a ON b.authorId = a.id " +
            "WHERE b.lastViewed IS NOT NULL ORDER BY b.lastViewed ASC")
    List<Book> findRecentBooks();

    @Query("SELECT b from Book b JOIN Author a ON b.authorId = a.id " +
            "WHERE b.likeCount IS NOT NULL ORDER BY b.lastViewed ASC")
    List<Book> findLikedBooks();
}
