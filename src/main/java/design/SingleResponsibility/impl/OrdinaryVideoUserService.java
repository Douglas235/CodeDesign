package design.SingleResponsibility.impl;

import design.SingleResponsibility.IVideoUserService;

/**
 * VIP user
 */
public class OrdinaryVideoUserService implements IVideoUserService {
    @Override
    public void definition() {
        System.out.println("Ordinary user");
    }

    @Override
    public void advertisement() {
        System.out.println("ordinary user have advert");
    }
}
