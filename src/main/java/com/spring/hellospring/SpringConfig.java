package com.spring.hellospring;


import com.spring.hellospring.repository.JdbcTemplateMemberRepository;
import com.spring.hellospring.repository.JpaMemberRepository;
import com.spring.hellospring.repository.MemberRepository;
import com.spring.hellospring.repository.MemoryMemberRepository;
import com.spring.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}
