package com.gethin.method3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 15:44
 * @description:
 */
public class DynamicProxy {

    public static <T> T createProxy(final T t) {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before();
                Object result = method.invoke(t, args);
                after();
                return result;
            }
            private void after() {
                System.out.println("call after");
            }

            private void before() {
                System.out.println("call before");
            }
        });
    }
}
