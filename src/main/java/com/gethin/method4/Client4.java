package com.gethin.method4;

import com.gethin.bean.Programmer;
import com.gethin.bean.Student;
import com.gethin.bean.Teacher;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 16:17
 * @description:
 */
public class Client4 {
    public static void main(String args[]) {
        Student studentCglibProxy=CglibDynamicProxy.createProxy(Student.class);
        studentCglibProxy.sayHello();
        Teacher teacherCglibProxy=CglibDynamicProxy.createProxy(Teacher.class);
        teacherCglibProxy.sayHello();
        Programmer programmerCglibProxy=CglibDynamicProxy.createProxy(Programmer.class);
        programmerCglibProxy.sayHello();
    }
}
