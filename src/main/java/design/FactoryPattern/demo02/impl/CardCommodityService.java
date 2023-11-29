package design.FactoryPattern.demo02.impl;

import com.alibaba.fastjson.JSON;
import design.FactoryPattern.demo.card.IQiYiCardService;
import design.FactoryPattern.demo.coupon.CouponResult;
import design.FactoryPattern.demo.coupon.CouponService;
import design.FactoryPattern.demo01.AwardReq;
import design.FactoryPattern.demo01.AwardRes;
import design.FactoryPattern.demo02.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CardCommodityService implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String s = queryUserPhoneNumber(uId);
        iQiYiCardService.grantToken(s,commodityId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }
    private String queryUserPhoneNumber(String uId){
        return "11122562";
    }
}
