package com.springboot.core;

import com.springboot.core.Order.Order;
import com.springboot.core.Order.OrderSerivce;
import com.springboot.core.Order.OrderSerivceImpl;
import com.springboot.core.member.Grade;
import com.springboot.core.member.Member;
import com.springboot.core.member.MemberSerivce;
import com.springboot.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
       /* MemberSerivce memberSerivce = new MemberServiceImpl(memberRepository);
        OrderSerivce orderSerivce = new OrderSerivceImpl();*/

//        AppConfig appConfig = new AppConfig();
//        MemberSerivce memberSerivce = appConfig.memberService();
//        OrderSerivce orderSerivce = appConfig.orderSerivce();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberSerivce memberSerivce = applicationContext.getBean("memberService",MemberSerivce.class);
        OrderSerivce orderSerivce = applicationContext.getBean("orderService",OrderSerivce.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberSerivce.join(member);

        Order order = orderSerivce.creatOrder(memberId,"itemA", 10000);

        System.out.println("order = " + order);
    }
}
