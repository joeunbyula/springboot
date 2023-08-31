package com.springboot.core.beanFind;

import com.springboot.core.AppConfig;
import com.springboot.core.member.MemberSerivce;
import com.springboot.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName() {
        MemberSerivce memberSerivce = ac.getBean("memberService", MemberSerivce.class);
        System.out.println("memberSerivce = " + memberSerivce);
        System.out.println("memberSerivce.getClass() = " + memberSerivce.getClass());

        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입으로 조회")
    void findBeanByType() {
        MemberSerivce memberSerivce = ac.getBean(MemberSerivce.class);
        System.out.println("memberSerivce = " + memberSerivce);
        System.out.println("memberSerivce.getClass() = " + memberSerivce.getClass());

        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberSerivce memberSerivce = ac.getBean("memberService",MemberServiceImpl.class);
        System.out.println("memberSerivce = " + memberSerivce);
        System.out.println("memberSerivce.getClass() = " + memberSerivce.getClass());

        assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }




}
