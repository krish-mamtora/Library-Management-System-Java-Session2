package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    public List<Book> getBookByMembreName(String memberName){
      return   borrowRecordRepository.findBooksBorrowedByMemberName(memberName);
    }
}
