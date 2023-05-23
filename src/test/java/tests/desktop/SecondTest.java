package tests.desktop;

import org.junit.jupiter.api.Test;
import pages.desktop.DepositConvenientPage;
import pages.desktop.DepositsPage;
import pages.desktop.HomeBankPage;

import java.util.Random;

public class SecondTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    DepositsPage depositsPage = new DepositsPage();
    DepositConvenientPage depositConvenientPage = new DepositConvenientPage();

    private final static String testSum1 = " ";
    private final static String testSum2 = "1000000000000000";

    private final static String testTime1 = "1000";
    private final static String testTime2 = " ";
    private final static String testTime3 = "22";
    private final static String time = "18";
    private final static String sum = "50000000";

    private final static String testName1 = "0";
    private final static String testName2 = "Petr Petrov";
    private final static String testName3 = "П";
    private final static String trueName = "П П";

    private final Random random = new Random();
    private final static int maxP = 1999999999;
    private final static int minP = 1000000000;
    private final static int testPhone = 1;
    int truePhone = random.nextInt(maxP - minP) + minP;


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
                .inputTimeDeposit(testTime3)
                .checkTimeDeposit3()
                .inputTimeDepositTrue()
                .checkTimeDeposit4()
                .wantFillAndOpenOnline();

        String stavka = depositsPage.checkStavka();
        String profit = depositsPage.checkProfit();
        String profitEnd = depositsPage.checkProfitEnd();


        depositsPage.openDeposit();

        depositConvenientPage.setupDeposit(time, sum)
                .checkDepositValues(stavka,profit,profitEnd)
                .clickArrange()
                .clickSend()
                .checkCaptions()
                .inputData(testName1)
                .checkInputFalseData1()
                .inputData(testName2)
                .checkInputFalseData1()
                .inputData(testName3)
                .checkInputFalseData2()
                .inputData(trueName)
                .inputPhone(testPhone)
                .checkPhone()
                .inputPhone(truePhone)
                .chooseCity()
                .chooseOffice()
                .clickSend()
                .checkApply();
    }
}
