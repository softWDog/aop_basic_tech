package com.gethin.method5;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/13 9:48
 * @description:
 */
public class ProxyChain {
    private Object targetObject;
    private MethodProxy methodProxy;
    private Object[] params;
    private Method method;
    List<Proxy> proxyList;
    private int currentIndex=0;

    public ProxyChain(Object targetObject, MethodProxy methodProxy, Object[] params, Method method, List<Proxy> proxyList) {
        this.targetObject = targetObject;
        this.methodProxy = methodProxy;
        this.params = params;
        this.method = method;
        this.proxyList = proxyList;
    }

    public Object doProxyChain() throws Throwable {
        Object result;
        if(currentIndex<proxyList.size()){
            result=proxyList.get(currentIndex++).doProxy(this);
        }else {
            result=methodProxy.invokeSuper(targetObject,params);
        }
        return result;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public MethodProxy getMethodProxy() {
        return methodProxy;
    }

    public Object[] getParams() {
        return params;
    }

    public Method getMethod() {
        return method;
    }

    public List<Proxy> getProxyList() {
        return proxyList;
    }
}
