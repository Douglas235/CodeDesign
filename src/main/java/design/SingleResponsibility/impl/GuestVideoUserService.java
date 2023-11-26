package design.SingleResponsibility.impl;

import design.SingleResponsibility.IVideoUserService;

/**
 * visitor
 */
public class GuestVideoUserService implements IVideoUserService {
    @Override
    public void definition() {
        System.out.println("Guest user ");
    }

    @Override
    public void advertisement() {
        System.out.println("Guest user ");
    }
}
