package com.springboot.core.discount;

import com.springboot.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
