package com.springboot.core.Order;

import com.springboot.core.annotation.MainDiscountPolicy;
import com.springboot.core.discount.DiscountPolicy;
import com.springboot.core.member.Member;
import com.springboot.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //생성자 자동 생성
public class OrderSerivceImpl implements OrderSerivce{

    /*
        생성자 주입은 불변, 누락을 막을 수 있다
        생성자에서 혹시라도 값이 설정되지 않은 오류를 컴파일 시점에 막아줌
        프레임워크에 의존 X, 순수한 자바 언어의 특징을 잘 살리는 방법
        따라서 생성자주입을 사용하자!
    */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //@Autowired //->생성자가 하나 있으면 @Autowired 생략가능하다. 자동으로 의존관계를 주입해준다.
    //생성자 주입은 스프링컨테이너에 빈 등록할 떄 주입된다.
    public OrderSerivceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //필드주입 -> 외부에서 변경이 불가능하기때문에 유연한 테스트가 불가능하다. setter생성해야함. 권장X 차라리 setter주입이 나음.
    //@Autowired private final MemberRepository memberRepository;
    //@Autowired private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
;        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
