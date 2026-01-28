package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord , Long> {
    @Query(
            value = "SELECT b. FROM borrow_record br JOIN member m ON br.member_id = m.id JOIN book b ON br.book_id = b.id WHERE m.name = :memberName",
            nativeQuery = true
    )
    List<Book> findBooksBorrowedByMemberName(@Param("memberName") String memberName);
}
