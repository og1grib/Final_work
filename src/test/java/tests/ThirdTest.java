package tests;

import org.junit.Test;
import pages.CreditCashPage;
import pages.CreditPage;
import pages.HomeBankPage;

public class ThirdTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    CreditPage creditPage = new CreditPage();
    CreditCashPage creditCashPage = new CreditCashPage();

    String testData1 = ".";
    String testData2 = "Ivan Ivanov";
    String testData3 = "0";


    @Test
    public void credit() {
        homeBankPage.openHomeBankPage()
                .clickCredit();
        creditPage.clickArrange();
        creditCashPage.clickButtonNext()
                .checkCaptions()
                .goalCredit();


    }
}
