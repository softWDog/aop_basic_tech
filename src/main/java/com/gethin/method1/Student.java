package com.gethin.method1;

import com.gethin.bean.Greeting;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 9:24
 * @description:
 */
class Student implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("call before");
        System.out.println("Hello,I'm student");
        System.out.println("call after");
    }
}
