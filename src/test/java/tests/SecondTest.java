package tests;

import org.junit.Test;
import pages.DepositsPage;
import pages.HomeBankPage;

public class SecondTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    DepositsPage depositsPage = new DepositsPage();

    @Test
    public void depositAndAccounts(){
        homeBankPage.openHomeBankPage()
                .clickDepositsAccounts();
        depositsPage.inputSumDeposit1()
                .checkSumDeposit1()
                .inputSumDeposit2()
                .checkSumDeposit2()
                .inputTimeDeposit1()
                .checkTimeDeposit1()
                .inputTimeDeposit2()
                .checkTimeDeposit2()
                .inputTimeDeposit3()
                .checkTimeDeposit3()
                .inputTimeDeposit4()
                .checkTimeDeposit4();
    }
}
