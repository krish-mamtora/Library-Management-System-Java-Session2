package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.repository.custom.BookRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> , BookRepositoryCustom {
    List<Book> findByLibraryId(Long libraryId);

    @Query("SELECT b FROM Book b WHERE b.available = true")
    List<Book> findAvailableBooks();

    @Query("SELECT br.book FROM BorrowRecord br WHERE br.member.id = :memberId")
    List<Book> findBookBorrowByMember(@Param("memberId") Long memberId);

    @Query(value = "SELECT * FROM books WHERE publishYear = :publishYear", nativeQuery = true)
    List<Book> findYearWiseBooks(@Param("publishYear") int pubYear);

//    List<Book> findAllBypubYear(String pubYear, Pageable pageable);
}
