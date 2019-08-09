package com.gethin.method1;

import com.gethin.bean.Greeting;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 14:45
 * @description:
 */
public class Client1 {
    public static void main(String args[]) {
        Greeting studentGreeting = new Student();
        studentGreeting.sayHello();
        Greeting teacherGreeting = new Teacher();
        teacherGreeting.sayHello();
        Greeting programmerGreeting = new Programmer();
        programmerGreeting.sayHello();
    }
}
