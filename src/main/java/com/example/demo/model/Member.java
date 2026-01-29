package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;

    private String email;
    private LocalDate membershipStartDate;
//    private List<BorrowRecord> borrowRecords = new ArrayList<>();
    
    @OneToOne(mappedBy = "member" , cascade = CascadeType.ALL)
    private MemberProfile profile;

    public Long getId() {

        return id;
    }
    public  Member(){

    }
    //List<BorrowRecord> borrowRecords,
    public Member(Long id, String name, String email, LocalDate membershipStartDate, MemberProfile profile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.membershipStartDate = membershipStartDate;
//        this.borrowRecords = borrowRecords;
        this.profile = profile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }
}
