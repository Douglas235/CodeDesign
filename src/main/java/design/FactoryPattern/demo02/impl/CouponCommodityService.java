package design.FactoryPattern.demo02.impl;

import com.alibaba.fastjson.JSON;
import design.FactoryPattern.demo.coupon.CouponResult;
import design.FactoryPattern.demo.coupon.CouponService;
import design.FactoryPattern.demo02.ICommodity;
import org.slf4j.LoggerFactory;

import java.util.Map;
import org.slf4j.Logger;

public class CouponCommodityService implements ICommodity {
    private Logger logger  = LoggerFactory.getLogger(CouponCommodityService.class);
    private CouponService couponService = new CouponService();
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数【优惠卷】=> uId:{} commodityId:{} bizId:{} extMap: {}",uId,commodityId,bizId,JSON.toJSONString(extMap));
        if(!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}

