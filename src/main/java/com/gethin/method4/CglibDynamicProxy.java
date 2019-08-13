package com.gethin.method4;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/9 16:10
 * @description:
 */
public class CglibDynamicProxy {
    public static <T> T createProxy(Class<T> tClass) {
        return (T) Enhancer.create(tClass, new MethodInterceptor() {
            public Object intercept(Object targetObject, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
                before();
                Object result = methodProxy.invokeSuper(targetObject, params);
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
