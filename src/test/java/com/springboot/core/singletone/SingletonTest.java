package com.springboot.core.singletone;

import com.springboot.core.AppConfig;
import com.springboot.core.member.MemberSerivce;
import com.springboot.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberSerivce memberSerivce = appConfig.memberService();
        MemberSerivce memberSerivce1 = appConfig.memberService();
        System.out.println("memberSerivce = " + memberSerivce);
        System.out.println("memberSerivce1 = " + memberSerivce1);

        //memberService != memberService1
        assertThat(memberSerivce).isNotSameAs(memberSerivce1);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        //same ==
        //equals .equlas()
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberSerivce memberSerivce = ac.getBean("memberService", MemberSerivce.class);
        MemberSerivce memberSerivce1 = ac.getBean("memberService", MemberSerivce.class);
        System.out.println("memberSerivce = " + memberSerivce);
        System.out.println("memberSerivce1 = " + memberSerivce1);

        //memberService != memberService1
        assertThat(memberSerivce).isSameAs(memberSerivce1);
    }
}
