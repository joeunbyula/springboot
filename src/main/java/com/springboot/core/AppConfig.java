package com.springboot.core;

import com.springboot.core.Order.OrderSerivce;
import com.springboot.core.Order.OrderSerivceImpl;
import com.springboot.core.discount.DiscountPolicy;
import com.springboot.core.discount.RateDiscountPolicy;
import com.springboot.core.member.MemberRepository;
import com.springboot.core.member.MemberSerivce;
import com.springboot.core.member.MemberServiceImpl;
import com.springboot.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService ->  new MemoryMemberRepository()
    @Bean
    public MemberSerivce memberService() {
        //System.out.println("1.AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        //System.out.println("2.3.5.AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderSerivce orderService() {
        //System.out.println("4.AppConfig.orderService");
        return new OrderSerivceImpl(memberRepository(), discountPolicy());
        //return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return  new RateDiscountPolicy();
    }
}
