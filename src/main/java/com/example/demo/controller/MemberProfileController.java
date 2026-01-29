package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member-profile")
public class MemberProfileController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public void createMember(@Valid @RequestBody Member member){
        memberService.addMember(member);
        System.out.println("Member Added");
    }


}
