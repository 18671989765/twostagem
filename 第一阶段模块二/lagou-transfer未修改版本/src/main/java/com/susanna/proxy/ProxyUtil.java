package com.susanna.proxy;

import com.susanna.config.TransferManager;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Component("proxyUtil")
public class ProxyUtil {

    /**
     * 使用动态代理去实例化对象
     */

    public Object proxyUtil(Object object) {

        /**
         * 使用动态代理实现实物控制
         */
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                try {
                    TransferManager.begin();
                    invoke = method.invoke(object, args);
                    TransferManager.commit();
                    //在这里进行实物处理

                } catch (Exception e) {
                    e.printStackTrace();
                    TransferManager.rollback();

                }
                return invoke;
            }
        });


    }

}
