package design.OpenClosedPrinciple.test;

import design.OpenClosedPrinciple.ICalculationArea;
import design.OpenClosedPrinciple.impl.CalculationAreaExtends;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_CalculationArea(){
        ICalculationArea area = new CalculationAreaExtends();
        double circular = area.circular(10);
        System.out.println(circular);
    }
}
