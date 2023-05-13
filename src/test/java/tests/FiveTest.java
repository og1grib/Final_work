package tests;

import org.junit.Test;
import pages.BusinessPage;
import pages.BusinessPaymentAccountantPage;
import pages.HomeBankPage;

public class FiveTest extends BaseTest{
    HomeBankPage homeBankPage = new HomeBankPage();
    BusinessPage businessPage = new BusinessPage();
    BusinessPaymentAccountantPage businessPaymentAccountantPage = new BusinessPaymentAccountantPage();

    @Test
    public void businessCredit() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

    }
}
