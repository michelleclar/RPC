package com.carl.producer;

import com.carl.HelloService;

/**
 * @program: RPC
 * @description:
 * @author: Mr.Carl
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
