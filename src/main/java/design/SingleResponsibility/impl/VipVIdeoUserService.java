package design.SingleResponsibility.impl;

import design.SingleResponsibility.IVideoUserService;

/**
 * vip
 */
public class VipVIdeoUserService  implements IVideoUserService {
    @Override
    public void definition() {
        System.out.println("VIP user");
    }

    @Override
    public void advertisement() {
        System.out.println("VIP user no advert");
    }
}
