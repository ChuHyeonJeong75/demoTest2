package com.example.demoTest1.repository;

import com.example.demoTest1.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer>{
}
