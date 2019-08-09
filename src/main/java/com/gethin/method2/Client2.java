package com.gethin.method2;

import com.gethin.bean.Greeting;
import com.gethin.bean.Programmer;
import com.gethin.bean.Student;
import com.gethin.bean.Teacher;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 15:10
 * @description:
 */
public class Client2 {
    public static void main(String args[]) {
        Greeting studentStaticProxy=new GreetingStaticProxy(new Student());
        studentStaticProxy.sayHello();
        Greeting teacherStaticProxy=new GreetingStaticProxy(new Teacher());
        teacherStaticProxy.sayHello();
        Greeting programmerStaticProxy=new GreetingStaticProxy(new Programmer());
        programmerStaticProxy.sayHello();
    }
}
