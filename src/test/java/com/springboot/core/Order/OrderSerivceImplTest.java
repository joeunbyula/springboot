package com.springboot.core.Order;

import com.springboot.core.discount.FixDiscountPolicy;
import com.springboot.core.member.Grade;
import com.springboot.core.member.Member;
import com.springboot.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderSerivceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderSerivceImpl orderSerivce = new OrderSerivceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderSerivce.creatOrder(1L, "itemA", 1000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}