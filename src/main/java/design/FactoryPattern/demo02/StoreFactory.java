package design.FactoryPattern.demo02;


import design.FactoryPattern.demo02.impl.CardCommodityService;
import design.FactoryPattern.demo02.impl.CouponCommodityService;
import design.FactoryPattern.demo02.impl.GoodsCommodityService;

public class StoreFactory {
    //奖品类型方式实例化
    public ICommodity getCommodityService(Integer comodityType){
        if(null == comodityType) return null;
        if(1 == comodityType) return  new CouponCommodityService();
        if(2 == comodityType) return new GoodsCommodityService();
        if(3 == comodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的奖品服务类型");
    }
    //奖品类信息方式实例化
    public ICommodity getCommodityService(Class<? extends  ICommodity> clazz) throws IllegalAccessException,InstantiationException{
        if(null == clazz) return null;
        return clazz.newInstance();
    }

}
