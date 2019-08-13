package com.gethin.method5;

import net.sf.cglib.proxy.MethodProxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: gethin
 * @email: denggx3@chinaunicom.cn
 * @Date: 2019/8/13 14:18
 * @description:
 */
public class BeforeProxy extends AbstractProxy {
    @Override
    public void before(Object targetObject, Object[] params, MethodProxy methodProxy) {
        System.out.println("call before");
    }
}
