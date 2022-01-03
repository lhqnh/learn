package com.lhqs.boot;

import com.lhqs.boot.bean.User;
import com.lhqs.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest

class Fuxi2Springboot4ApplicationTests {


    @Autowired
    UserService userService;

    @Test
    void contextLoads() {

        /*User hello = userService.findUser("hello");
        System.out.println(hello);
        List<User> list = userService.list();
        System.out.println(list);*/
        /*boolean b = userService.removeById(5);
        System.out.println(b);*/
        boolean b = userService.deleteUserById(5);
        System.out.println(b);

    }

}
