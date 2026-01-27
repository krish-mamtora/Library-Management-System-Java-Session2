package com.example.demo.dto;

import java.time.LocalDate;

public class BorrowRecordDTO
{
    private Long memberId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate returndate;

    private String satus;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }

    public String getSatus() {
        return satus;
    }

    public void setSatus(String satus) {
        this.satus = satus;
    }
}
