package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "member_profiles")
public class MemberProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Gender;
    private int age;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public MemberProfile(){

    }
    public MemberProfile(Long id, String gender, int age, String address) {
        this.id = id;
        Gender = gender;
        this.age = age;
        this.address = address;
    }

    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
