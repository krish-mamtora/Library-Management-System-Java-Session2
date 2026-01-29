package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService  {
    List<Member> allMembers = new ArrayList<>();

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMembers(){
        return allMembers;
    }

    public Member getMemberById(Long memberId){
        return allMembers.stream()
                .filter(p->p.getId() == memberId)
                .findFirst().get();
    }

    public void addMember(Member member){
        allMembers.add(member);
    }
    public void updateMember(Member member){
        int index = 0;
        for(int i=0;i<allMembers.size();i++){
            if(allMembers.get(i).getId()==member.getId()){
                index = i;
            }
        }
        allMembers.set(index , member);
    }
}
