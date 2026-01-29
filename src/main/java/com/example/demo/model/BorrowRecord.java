package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_records")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate borrowDate;
    private LocalDate returndate;
    private String status;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowRecord(){

    }

    public BorrowRecord(Long id, LocalDate borrowDate, LocalDate returndate, String status) {
        this.id = id;
//        this.borrowDate = borrowDate;
//        this.returndate = returndate;
//        this.status = status;
    }

}

