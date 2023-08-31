package com.springboot.core;

import com.springboot.core.member.Grade;
import com.springboot.core.member.Member;
import com.springboot.core.member.MemberSerivce;
import com.springboot.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //MemberSerivce memberSerivce = new MemberServiceImpl();
//        AppConfig appConfig = new AppConfig();
//        MemberSerivce memberSerivce = appConfig.memberSerivce();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberSerivce memberSerivce = applicationContext.getBean("memberService",MemberSerivce.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberSerivce.join(member);

        Member member1 = memberSerivce.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("member1 = " + member1.getName());
    }
}
