package com.gethin.method5;

import com.gethin.bean.Greeting;
import com.gethin.bean.Student;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/13 17:20
 * @description:
 */
public class Client5 {
public static void main(String args[]) {
    //加入前置增强
    Student beforeGreeting= new BeforeProxy().getProxy(Student.class);
    //加入后置增强
    Student afterGreeting=new AfterProxy().getProxy(beforeGreeting.getClass());
    //输出增强效果
    afterGreeting.sayHello();
}
}
