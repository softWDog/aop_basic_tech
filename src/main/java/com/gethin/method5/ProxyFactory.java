package com.gethin.method5;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/13 9:50
 * @description:
 */
public class ProxyFactory {
    public static <T> T createProxy(Class<T> tClass, final List<Proxy> proxyList){
       return (T) Enhancer.create(tClass, new MethodInterceptor() {
            public Object intercept(Object targetObject, Method originMethod, Object[] params, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain(targetObject,methodProxy,params,originMethod,proxyList).doProxyChain();
            }
        });
    }
}
