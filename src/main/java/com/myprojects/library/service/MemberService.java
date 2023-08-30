package com.myprojects.library.service;
import com.myprojects.library.model.Member;
import com.myprojects.library.repository.MemberRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void addMember(Member member) {
        memberRepository.insert(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
