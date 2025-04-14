package grouping;

import org.testng.annotations.Test;

public class PaymentTests {

    @Test(groups = {"sanity","regression","functional"})
    public void paymentINRupees(){
        System.out.println("payment in rs");
    }

    @Test(groups = {"sanity","regression","functional"})
    public void paymentINDollars(){
        System.out.println("payment in dollars");
    }
}
