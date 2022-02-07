package com.example.firstproject.repository;

import com.example.firstproject.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    //JPA를 사용하기 위해서는 EntityManager 주입이 필요함
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByid(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByname(String name) {
        List<Member> result = em.createQuery("select m from Member m Where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //JPQL 객체 대상으로 쿼리를 하는 것(정확하게는 Entity 대상)
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
