package com.gethin.method2;

import com.gethin.bean.Greeting;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 15:08
 * @description:
 */
public class GreetingStaticProxy implements Greeting {
    private Greeting greeting;

    public GreetingStaticProxy(Greeting greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayHello() {
        before();
        greeting.sayHello();
        after();
    }

    private void after() {
        System.out.println("call after");
    }

    private void before() {
        System.out.println("call before");
    }
}
