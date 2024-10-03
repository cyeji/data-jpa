package com.yeji.datajpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
@Transactional
class MemberTest {

    @PersistenceContext EntityManager em;

    @Test
    @DisplayName("엔티티 테스트")
    void test_case_1() throws Exception {
        // given
        Team team = Team.from("teaAm");
        Team team2 = Team.from("teamB");
        em.persist(team);
        em.persist(team2);
        // when
        Member member1 = Member.of("member1", 10, team);
        Member member2 = Member.of("member2", 20, team);
        Member member3 = Member.of("member3", 30, team2);
        Member member4 = Member.of("member4", 40, team2);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();
        // then
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

        for (Member member : members) {
            log.info("member = {}", member);
            log.info("-> member.team = {}", member.getTeam());
        }
    }

}