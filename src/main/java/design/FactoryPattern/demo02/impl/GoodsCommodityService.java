package design.FactoryPattern.demo02.impl;


import com.alibaba.fastjson.JSON;
import design.FactoryPattern.demo.goods.DeliverReq;
import design.FactoryPattern.demo.goods.GoodsService;
import design.FactoryPattern.demo02.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

public class GoodsCommodityService  implements ICommodity {
    private GoodsService goodsService = new GoodsService();
    private DeliverReq deliverReq = new DeliverReq();
    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
        Boolean isSuccess = goodsService.deliverGoods(deliverReq);
        logger.info("请求参数[实物商品] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[实物商品]：{}", isSuccess);
        if (!isSuccess) throw new RuntimeException("实物商品发放失败");

    }
    private String queryUserName(String uId){
        return "花花";
    }
    private String queryUserPhoneNumber(String uId){
        return "11122562";
    }
}
