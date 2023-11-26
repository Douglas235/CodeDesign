package design.SingleResponsibilty.test;

import design.SingleResponsibility.IVideoUserService;
import design.SingleResponsibility.impl.GuestVideoUserService;

public class ApiTest {
    public static void main(String[] args) {
        IVideoUserService guest = new GuestVideoUserService();
        guest.advertisement();
        guest.definition();
    }
}
