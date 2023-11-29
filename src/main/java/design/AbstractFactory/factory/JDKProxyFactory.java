package design.AbstractFactory.factory;

import design.AbstractFactory.workshop.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyFactory {
    //用于创建指定接口类型的代理对象。
    public static <T> T getProxy(Class<T> cacheClazz, Class<? extends ICacheAdapter> cacheAdapter)throws Exception{
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter.newInstance());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //使用`Proxy.newProxyInstance`方法创建代理对象，传入类加载器、接口类型数组和`InvocationHandler`对象。
        // 将代理对象转换为指定接口类型`cacheClazz`并返回。
        return (T) Proxy.newProxyInstance(classLoader,new Class[]{cacheClazz},handler);
    }
}
