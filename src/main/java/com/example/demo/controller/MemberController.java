package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public void createMember(@RequestBody MemberDTO dto){
        Member member  = memberService.CreateMember(dto);
        System.out.println("Member Added");
    }

    @GetMapping
    public Set<Member> getAllMembers(){
        return memberService.getAllMembers();
    }
}
