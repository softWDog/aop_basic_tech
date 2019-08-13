package com.gethin.method6;

import net.sf.cglib.proxy.MethodProxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/13 14:20
 * @description:
 */
public class AfterProxy extends AbstractProxy {
    @Override
    public void after(Object targetObject, Object[] params, MethodProxy methodProxy) {
        System.out.println("call after");
    }
}
