package design.AbstractFactory.test;

import design.AbstractFactory.factory.JDKProxyFactory;
import design.AbstractFactory.redis.CacheService;
import design.AbstractFactory.workshop.impl.EGMCacheAdapter;
import design.AbstractFactory.workshop.impl.IIRCacheAdapter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * 由于集群A和集群B在部分方法提供上是不同的，
     * 因此需要做一个接口适配，而这个适配类就相当于工厂中的工厂，
     * 用于创建把不同的服务抽象为统一的接口做相同的业务
     * @throws Exception
     */
    @Test
    public void test_CacheService() throws Exception {
        CacheService proxy_EGM = JDKProxyFactory.getProxy(CacheService.class, EGMCacheAdapter.class);
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        logger.info("缓存服务 EGM 测试，proxy_EGM.get 测试结果：{}", val01);

        CacheService proxy_IIR = JDKProxyFactory.getProxy(CacheService.class, IIRCacheAdapter.class);
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        logger.info("缓存服务 IIR 测试，proxy_IIR.get 测试结果：{}", val02);
    }
}
