package tests.desktop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.desktop.DepositConvenientPage;
import pages.desktop.DepositsPage;
import pages.desktop.HomeBankPage;

import java.util.Random;

@DisplayName("Поверка сценария: оформление вклада")
public class SecondTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    DepositsPage depositsPage = new DepositsPage();
    DepositConvenientPage depositConvenientPage = new DepositConvenientPage();
    private final Random random = new Random();

    private final static String valueFieldSum1 = "1 000 ₽";
    private final static String valueFieldSum2 = "50 000 000 ₽";

    private final static String testSum1 = " ";
    private final static String testSum2 = "1000000000000000";

    private final static String valueFieldTime1 = "36 месяцев";
    private final static String valueFieldTime2 = "3 месяца";
    private final static String valueFieldTime3 = "24 месяца";
    private final static String valueFieldTime4 = "18 месяцев";

    private final static String nameCaption = "Укажите фамилию, имя и отчество контактного лица";
    private final static String phoneCaption = "Введите верный номер телефона";
    private final static String cityCaption = "Выберите ваш населенный пункт";
    private final static String officeCaption = "Выберите офис";

    private final static String dataFalseCaption1 = "Используйте только кириллицу";
    private final static String dataFalseCaption2 = "Укажите фамилию, имя и отчество";

    private final static String applyCaption = "Заявка принята";

    private final static String testTime1 = "1000";
    private final static String testTime2 = " ";
    private final static String testTime3 = "22";
    private final static String time = "18";
    private final static String sum = "50000000";

    private final static String testName = "П";
    private final static String trueName = "П П";

    private final static int maxP = 1999999999;
    private final static int minP = 1000000000;
    private final static int testPhone = 1;
    int truePhone = random.nextInt(maxP - minP) + minP;

    @DisplayName("Ввод пробела в поле \"Сумма вклада\"")
    @Test
    public void depositAndAccountsSumSpace() {
        homeBankPage.openHomeBankPage()
                .clickDepositsAccounts();

        depositsPage.inputSumDeposit(testSum1)
                .checkSumDeposit(valueFieldSum1);
    }

    @DisplayName("Ввод в поле \"Сумма вклада\" большого числа")
    @Test
    public void depositAndAccountsSumBig() {
        homeBankPage.openHomeBankPage()
                .clickDepositsAccounts();

        depositsPage.inputSumDeposit(testSum2)
                .checkSumDeposit(valueFieldSum2);
    }

    @DisplayName("Ввод пробела в поле \"Срок вклада\"")
    @Test
    public void depositAndAccountsTimeSpace() {
        homeBankPage.openHomeBankPage()
                .clickDepositsAccounts();

        depositsPage.inputTimeDeposit(testTime2)
                .checkTimeDeposit(valueFieldTime2);
    }

//    @DisplayName("Ввод в поле \"Срок вклада\" большое значение")
//    @Test
//    public void depositAndAccountsTimeBig() {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputTimeDeposit(testTime1)
//                .checkTimeDeposit(valueFieldTime1);
//    }
//
//    @DisplayName("Ввод пробела в поле \"Срок вклада\" значение \"22\" - между 20 и 24")
//    @Test
//    public void depositAndAccountsTimeBetween() {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputTimeDeposit(testTime3)
//                .checkTimeDeposit(valueFieldTime3);
//    }
//
//    @DisplayName("Нажать на кнопку с цифрой под полем \"Срок вклада\"")
//    @Test
//    public void depositAndAccountsTimeButton() {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputTimeDepositTrue()
//                .checkTimeDeposit(valueFieldTime4);
//    }
//
//    @DisplayName("Проверка данных на странице с выбором вклада и на отдельной странице вклада")
//    @Test
//    public void depositAndAccountsCheckData() {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputSumDeposit(testSum2)
//                .inputTimeDepositTrue()
//                .wantFillAndOpenOnline();
//
//        String stavka = depositsPage.checkStavka();
//        String profit = depositsPage.checkProfit();
//        String profitEnd = depositsPage.checkProfitEnd();
//
//        depositsPage.openDeposit();
//
//
//        depositConvenientPage.setupDeposit(time, sum)
//                .checkDepositValues(stavka, profit, profitEnd);
//    }
//
//    @DisplayName("Проверка отправления заявки с пустыми полями")
//    @Test
//    public void depositAndAccountsEmptyField() {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputSumDeposit(testSum2)
//                .inputTimeDepositTrue()
//                .wantFillAndOpenOnline()
//                .openDeposit();
//
//
//        depositConvenientPage.setupDeposit(time, sum)
//                .clickArrange()
//                .clickSend()
//                .checkCaptions(nameCaption, phoneCaption, cityCaption, officeCaption);
//    }
//
//    @DisplayName("Ввод на отдельной странице вклада в поле \"ФИО\" чисел и английских букв")
//    @ParameterizedTest
//    @ValueSource(strings = {"0", "Petr Petrov"})
//    public void depositAndAccountsFalseFIO(String name) {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputSumDeposit(testSum2)
//                .inputTimeDepositTrue()
//                .wantFillAndOpenOnline()
//                .openDeposit();
//
//
//        depositConvenientPage.setupDeposit(time, sum)
//                .clickArrange()
//                .inputData(name)
//                .checkInputFalseData(dataFalseCaption1);
//    }
//
//    @DisplayName("Ввод на отдельной странице вклада в поле \"ФИО\" одной буквы")
//    @Test
//    public void depositAndAccountsOneCharFIO() {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputSumDeposit(testSum2)
//                .inputTimeDepositTrue()
//                .wantFillAndOpenOnline()
//                .openDeposit();
//
//
//        depositConvenientPage.setupDeposit(time, sum)
//                .clickArrange()
//                .inputData(testName)
//                .checkInputFalseData(dataFalseCaption2);
//    }
//
//
//    @DisplayName("Ввод на отдельной странице вклада в поле \"Мобильный телефон\" одной цифры")
//    @Test
//    public void depositAndAccountsOneNumberPhone() {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputSumDeposit(testSum2)
//                .inputTimeDepositTrue()
//                .wantFillAndOpenOnline()
//                .openDeposit();
//
//
//        depositConvenientPage.setupDeposit(time, sum)
//                .clickArrange()
//                .clickSend()
//                .inputPhone(testPhone)
//                .checkPhone(phoneCaption);
//    }
//
//    @DisplayName("Заполнение и отправка формы на депозит на отдельной странице")
//    @Test
//    public void depositAndAccountsTrue() {
//        homeBankPage.openHomeBankPage()
//                .clickDepositsAccounts();
//
//        depositsPage.inputSumDeposit(testSum2)
//                .inputTimeDepositTrue()
//                .wantFillAndOpenOnline()
//                .openDeposit();
//
//
//        depositConvenientPage.setupDeposit(time, sum)
//                .clickArrange()
//                .clickSend()
//                .inputData(trueName)
//                .inputPhone(truePhone)
//                .chooseCity()
//                .chooseOffice()
//                .clickSend()
//                .checkApply(applyCaption);
//    }
}
