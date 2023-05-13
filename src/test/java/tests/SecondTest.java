package tests;

import org.junit.Test;
import pages.DepositConvenientPage;
import pages.DepositsPage;
import pages.HomeBankPage;

public class SecondTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    DepositsPage depositsPage = new DepositsPage();
    DepositConvenientPage depositConvenientPage = new DepositConvenientPage();

    String testSum1 = " ";
    String testSum2 = "1000000000000000";
    String testTime1 = "1000";
    String testTime2 = " ";
    String testName1 = "0";
    String testName2 = ".";
    String testName3 = "a b";


    @Test
    public void depositAndAccounts(){
        homeBankPage.openHomeBankPage()
                .clickDepositsAccounts();
        depositsPage.inputSumDeposit(testSum1)
                .checkSumDeposit1()
                .inputSumDeposit(testSum2)
                .checkSumDeposit2()
                .inputTimeDeposit(testTime1)
                .checkTimeDeposit1()
                .inputTimeDeposit(testTime2)
                .checkTimeDeposit2()
                .inputTimeDeposit2()
                .checkTimeDeposit3()
                .inputTimeDeposit4()
                .checkTimeDeposit4()
                .wantFillAndOpenOnline();

        String stavka = depositsPage.checkStavka();
        String profit = depositsPage.checkProfit();
        String profitEnd = depositsPage.checkProfitEnd();

        depositsPage.openDeposit();

        depositConvenientPage.setupDeposit()
                .checkDepositValues(stavka,profit,profitEnd)
                .clickArrange()
                .clickSend()
                .checkCaptions();


    }
}
