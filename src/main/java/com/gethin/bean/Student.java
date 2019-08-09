package com.gethin.bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 9:24
 * @description:
 */
public class Student implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello,I'm student");
    }
}
