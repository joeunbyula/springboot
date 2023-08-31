package com.springboot.core.scan;

import com.springboot.core.AutoAppConfig;
import com.springboot.core.member.MemberSerivce;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberSerivce mem = ac.getBean(MemberSerivce.class);

        assertThat(mem).isInstanceOf(MemberSerivce.class);

    }

}
