package com.example.firstproject.service;

import com.example.firstproject.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMembers = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMembers.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}