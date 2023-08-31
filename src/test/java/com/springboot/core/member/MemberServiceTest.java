package com.springboot.core.member;

import com.springboot.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    /*MemberSerivce memberSerivce = new MemberServiceImpl(memberRepository);*/
    AppConfig appConfig = new AppConfig();
    MemberSerivce memberSerivce = appConfig.memberService();
    @Test
    void join() {
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when
        memberSerivce.join(member);
        Member member1 = memberSerivce.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(member1);
    }
}
