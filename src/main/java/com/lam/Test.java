package com.lam;

import com.lam.service.UserService;
import com.spring.ApplicationContext;


public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();

    }
}
