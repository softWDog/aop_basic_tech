package com.gethin.method1;

import com.gethin.bean.Greeting;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 9:32
 * @description:
 */
class Programmer implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("call before");
        System.out.println("Hello,I'm programmer");
        System.out.println("call after");
    }
}
