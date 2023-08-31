package com.springboot.core.discount;

import com.springboot.core.annotation.MainDiscountPolicy;
import com.springboot.core.member.Grade;
import com.springboot.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy") --> string형식이라 컴파일타임에선 오류를 잡지 못하기 떄문에 애노테이션을 만들어 사용하는 것이 좋다.
@MainDiscountPolicy
public class RateDiscountPolicy implements  DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
