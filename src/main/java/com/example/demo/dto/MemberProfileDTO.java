package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class MemberProfileDTO {

    @NotBlank(message = "UserName is Required")
    private String name;
    private String email;
    private String address;
    private LocalDate membershipStartDate;

    public MemberProfileDTO(){

    }

    public MemberProfileDTO(String name, String email, String address, LocalDate membershipStartDate) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.membershipStartDate = membershipStartDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }
}
