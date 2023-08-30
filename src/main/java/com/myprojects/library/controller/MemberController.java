package com.myprojects.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.myprojects.library.model.Member;
import com.myprojects.library.service.MemberService;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
       this.memberService = memberService;
    }

    @GetMapping
    public List<Member> GetMembers() {
        return memberService.getAllMembers();
    } 

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void AddMember(@RequestBody Member member) {
        memberService.addMember(member);
    }
}
