package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();
    // 테스트 끝날때마다 memberRepository.clearStore() 실행.
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // 새 멤버 객체 생성,초기화
        Member member = new Member("hello", 20);
        // 위의 멤버 저장
        Member savedMember = memberRepository.save(member);
        // 위의 멤버 찾기
        Member findMember = memberRepository.findById(savedMember.getId());
        // 찾은 멤버와 저장한 멤버가 같느냐 -> 같다. -> 저장성공.
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // 두 멤버 1,2 객체 생성
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        // 생성한 두 멤버 객체 저장
        memberRepository.save(member1);
        memberRepository.save(member2);
        // 저장된 모든 Member타입 List
        List<Member> result = memberRepository.findAll();
        // result 의 사이즈가 2냐 ? ㅇㅇ
        Assertions.assertThat(result.size()).isEqualTo(2);
        // result 에 member1 과 member2 가 포함이냐 ? ㅇㅇ
        Assertions.assertThat(result).contains(member1, member2);
    }
}
