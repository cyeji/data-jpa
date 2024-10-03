package com.yeji.datajpa.repository;

import com.yeji.datajpa.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@Transactional
@SpringBootTest
class MemberJpaRepositoryTest {

    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @Test
    @DisplayName("회원 테스트")
    void test_case_1() throws Exception {
        // given
        Member member = Member.from("yeji");
        // when
        Member savedMember = memberJpaRepository.save(member);
        // then
        Member findMember = memberJpaRepository.find(savedMember.getId());

        assertEquals(findMember.getId(), savedMember.getId());
        assertEquals(findMember.getUsername(), savedMember.getUsername());
    }

}