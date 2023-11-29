package design.FactoryPattern.demo02;

import java.util.Map;

//发放商品接口
public interface ICommodity {
    void sendCommodity(String uId, String commodityId, String bizId, Map<String ,String> extMap) throws Exception;
}
