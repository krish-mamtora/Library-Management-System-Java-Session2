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

    @Query("select b from Book b where b.available = true")
    List<Book> findAvailableBooks();

    @Query("select b from BorrowRecord b where b.member.id = :memberId")
    List<Book> findBookBorrowByMember(@Param("memberId") Long memberId);

    @Query(value = "select * from books where publishYear = :publishYear", nativeQuery = true)
    List<Book> findYearWiseBooks(@Param("publishYear") int publishYear);

//    List<Book> findAllBypubYear(String publishYear, Pageable pageable);
}
