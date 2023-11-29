package design.AbstractFactory.factory;

import design.AbstractFactory.util.ClassLoaderUtils;
import design.AbstractFactory.workshop.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {
    /**
     * 实现适配器，代理工厂实现的 适配器下的两套集群的具体工厂中的服务
     * 提供工厂的工厂
     */
    private ICacheAdapter cacheAdapter;


    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter,args);
    }
}
