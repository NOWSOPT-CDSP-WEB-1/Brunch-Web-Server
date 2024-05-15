package com.brunch.server.book.repository;

import com.brunch.server.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b JOIN Author a ON b.author_id = a.id ORDER BY b.id DESC")
    List<Book> findRecentBooks();

    @Query("SELECT b from Book b JOIN Author a ON b.author_id = a.id ORDER BY b.likeCount DESC")
    List<Book> findLikedBooks();
}
