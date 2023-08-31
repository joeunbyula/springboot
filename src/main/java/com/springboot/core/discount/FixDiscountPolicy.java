package com.springboot.core.discount;

import com.springboot.core.member.Grade;
import com.springboot.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{
    private int discpuntFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discpuntFixAmount;
        } else {
            return 0;
        }
    }
}
