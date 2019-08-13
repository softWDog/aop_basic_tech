package com.gethin.method5;

import com.gethin.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/13 15:02
 * @description:
 */
public class Client5 {
    public static void main(String args[]) {
        BeforeProxy beforeProxy = new BeforeProxy();
        AfterProxy afterProxy = new AfterProxy();
        List<Proxy> proxyList = new ArrayList<Proxy>();
        proxyList.add(afterProxy);
        proxyList.add(beforeProxy);
        Student student = ProxyFactory.createProxy(Student.class, proxyList);
        student.sayHello();
    }
}
