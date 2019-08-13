package com.gethin.method5;

import net.sf.cglib.proxy.MethodProxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/13 13:13
 * @description:
 */
public abstract class AbstractProxy implements Proxy {
    public Object doProxy(ProxyChain proxyChain) {
        Object targetObject = proxyChain.getTargetObject();
        Object[] params = proxyChain.getParams();
        MethodProxy methodProxy = proxyChain.getMethodProxy();
        Object result=null;
        begin();
        try {
            before(targetObject, params, methodProxy);
            result = proxyChain.doProxyChain();
            after(targetObject, params, methodProxy);
        } catch (Throwable throwable) {
            error(targetObject, params, methodProxy);
        }
        end();
        return result;
    }

    public void end() {
    }

    public void error(Object targetObject, Object[] params, MethodProxy methodProxy) {
    }

    public void after(Object targetObject, Object[] params, MethodProxy methodProxy) {
    }

    public void before(Object targetObject, Object[] params, MethodProxy methodProxy) {
    }


    public void begin() {

    }
}
