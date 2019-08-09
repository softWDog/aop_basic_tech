package com.gethin.method3;

import com.gethin.bean.Greeting;
import com.gethin.bean.Programmer;
import com.gethin.bean.Student;
import com.gethin.bean.Teacher;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 15:50
 * @description:
 */
public class Client3 {
    public static void main(String args[]) {
        Greeting studentDynaminProxy = DynamicProxy.createProxy(new Student());
        studentDynaminProxy.sayHello();
        Greeting teacherDynicProxy = DynamicProxy.createProxy(new Teacher());
        teacherDynicProxy.sayHello();
        Greeting programmerDynicProxy = DynamicProxy.createProxy(new Programmer());
        programmerDynicProxy.sayHello();
    }
}
