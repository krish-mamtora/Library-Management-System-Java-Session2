package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public void createMember(@RequestBody Member member){
        memberService.addMember(member);
        System.out.println("Member Added");
    }
    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getMembers();
    }
    @GetMapping("/{id}")
    public Member getMember(Long id){
        return memberService.getMemberById(id);
    }

}
