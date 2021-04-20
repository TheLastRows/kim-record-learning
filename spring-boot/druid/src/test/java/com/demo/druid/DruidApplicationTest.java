package com.demo.druid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
class DruidApplicationTest {

    @Resource
    private ApplicationContext applicationContext;


    @Test
    void applicationContextInitTest() {
        Assertions.assertNotNull(applicationContext);
    }
}