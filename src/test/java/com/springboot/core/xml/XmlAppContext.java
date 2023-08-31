package com.springboot.core.xml;

import com.springboot.core.member.MemberSerivce;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


public class XmlAppContext {

    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberSerivce memberSerivce = ac.getBean("memberService", MemberSerivce.class);
        assertThat(memberSerivce).isInstanceOf(MemberSerivce.class);
    }
}
