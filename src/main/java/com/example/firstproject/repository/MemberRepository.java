package com.example.firstproject.repository;

import com.example.firstproject.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByid(Long id);
    Optional<Member> findByname(String name);
    List<Member> findAll();
}
