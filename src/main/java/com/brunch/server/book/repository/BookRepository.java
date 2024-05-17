package com.brunch.server.book.repository;

import com.brunch.server.book.entity.Book;
import com.brunch.server.posting.entity.Posting;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // RecentAndLikedBooks
    @Query("SELECT b FROM Book b JOIN Author a ON b.authorId = a.id " +
            "WHERE b.lastViewed IS NOT NULL ORDER BY b.lastViewed ASC")
    List<Book> findRecentBooks();

    @Query("SELECT b FROM Book b JOIN Author a ON b.authorId = a.id " +
            "WHERE b.likeCount IS NOT NULL ORDER BY b.lastViewed ASC")
    List<Book> findLikedBooks();

    // BookDetail
    @Query("SELECT b FROM Book b JOIN Author a ON b.authorId = a.id " +
            "WHERE b.id = :bookId")
    List<Book> findBookOverview(long bookId);

    @Query("SELECT p FROM Posting p WHERE p.bookId = :bookId")
    List<Posting> findBookChapter(long bookId);


    // Banner
    @Query("SELECT b FROM Book b JOIN Author a ON b.authorId = a.id " +
            "WHERE b.bannerImage IS NOT NULL")
    List<Book> findBanner();

    // BookLike
    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.likeCount = b.likeCount + 1 " +
            "WHERE b.id = :bookId")
    void increaseLikeCount(long bookId);

}
