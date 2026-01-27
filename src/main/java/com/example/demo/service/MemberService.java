package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService  {
    @Autowired
    private MemberRepository memberRepository;

    public void CreateMember(MemberDTO dto){
     //match later   Member member = new Member(dto.getName(),dto.getEmail(), dto.getMembershipStartDate() );

    }

}
