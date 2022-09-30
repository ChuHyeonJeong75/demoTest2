package com.example.demoTest1.repository;

import com.example.demoTest1.DemoTest1ApplicationTests;
import com.example.demoTest1.model.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@WebAppConfiguration
public class MemberRepositoryTest extends DemoTest1ApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void create(){
        Member m = new Member();
        m.setName("cho");
        m.setEmail("cho200@nnaver.com");
        m.setCreateAt(LocalDateTime.now());
        m.setCreateBy("Admin");

        System.out.println(m.toString());
        memberRepository.save(m);
    }
    @Test
    public void read(){
        Optional<Member> member = memberRepository.findById(1);

        Assertions.assertTrue(member.isPresent());
        //Member m

        member.ifPresent( m -> {
            System.out.println(m.getName());
        });

        System.out.println("종료");
    }

        @Test
        @Transactional  //실제값에 영향을 미치지 않음
        public void update() {
            Optional<Member> member = memberRepository.findById(2);

            member.ifPresent(m ->{
                m.setName("Cuk");
                memberRepository.save(m);
            });
            System.out.println("업데이트 종료");
        }
    }