package tests.desktop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.desktop.CreditCashPage;
import pages.desktop.CreditPage;
import pages.desktop.HomeBankPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@DisplayName("Поверка сценария: оформление кредита наличными")
public class ThirdTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    CreditPage creditPage = new CreditPage();
    CreditCashPage creditCashPage = new CreditCashPage();

    private final static String goalCaption = "Это поле обязательно для заполнения";
    private final static String dataCaption = "Введите ФИО полностью";
    private final static String dataCaptionFalse = "Используйте только кириллицу";
    private final static String dataCaptionBig = "Не более 255 символов";
    private final static String birthdayCaption = "Обязательное поле";
    private final static String birthdayCaptionOld = "Возраст клиента должен быть не более 70 лет";
    private final static String birthdayCaptionYoung = "Возраст клиента должен быть не менее 20 лет";
    private final static String phoneCaption = "Обязательное поле";
    private final static String phoneCaptionFalse = "Введите верный номер телефона";
    private final static String emailCaption = "Введите верный электронный адрес";
    private final static String conditionCaption = "Для подачи заявки необходимо дать согласие на этот пункт";
    private final static String codeFalse = "Неправильный код";

    private final static String sumMin = "20 000 ₽";
    private final static String sumMax = "5 000 000 ₽";
    private final static String timeMin = "12 месяцев";
    private final static String timeMax = "60 месяцев";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    static LocalDate oldDate = LocalDate.now().minusYears(80);
    static LocalDate youngDate = LocalDate.now().minusYears(2);
    static LocalDate trueDate = LocalDate.now().minusYears(20);
    String oldDateString = oldDate.format(formatter);
    String youngDateString = youngDate.format(formatter);
    String trueDateString = trueDate.format(formatter);

    private final static String testDataBig = "Ааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа бббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббб";
    private final static String trueData = "Иван Иванов";

    private final Random random = new Random();
    private final static int maxP = 1999999999;
    private final static int minP = 1000000000;
    private final static int phoneTest = 1;
    int truePhone = random.nextInt(maxP - minP) + minP;

    private final static String testEmail = "0";
    private final static String trueEmail = "/@м.р";

    private final static String testSum1 = " ";
    private final static String testSum2 = "100000000000";

    private final static String testTime1 = " ";
    private final static String testTime2 = "100";

    private final static int maxC = 9;
    private final static int minC = 0;
    int num1 = random.nextInt(maxC - minC) + minC;
    int num2 = random.nextInt(maxC - minC) + minC;
    int num3 = random.nextInt(maxC - minC) + minC;
    int num4 = random.nextInt(maxC - minC) + minC;

    @DisplayName("Отправка заявки на кредит с пустыми полями")
    @Test
    public void creditEmptyFields() {
        homeBankPage.openHomeBankPage()
                .clickCredit();

        creditPage.clickArrange();

        creditCashPage.clickButtonNext()
                .checkCaptions(goalCaption, dataCaption, birthdayCaption, phoneCaption);
    }

    @DisplayName("Ввод в поле \"ФИО\": ")
    @ParameterizedTest
    @ValueSource(strings = {".", "0", "Petr Petrov"})
    public void creditFalseFIO(String name) {
        homeBankPage.openHomeBankPage()
                .clickCredit();

        creditPage.clickArrange();

        creditCashPage.inputData(name)
                .checkCaptionData(dataCaptionFalse);
    }

//    @DisplayName("Ввод в поле \"ФИО\" большого числа знаков: ")
//    @Test
//    public void creditFalseFIO2() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputData(testDataBig)
//                .checkCaptionData(dataCaptionBig);
//    }
//
//    @DisplayName("Ввод в поле \"Дата рождения\" - \"сегодняшяя дата \"-\" 80 лет\"")
//    @Test
//    public void creditFalseOldBirthday() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputBirthday(oldDateString)
//                .checkBirthday(birthdayCaptionOld);
//    }
//
//    @DisplayName("Ввод в поле \"Дата рождения\" - \"сегодняшяя дата \"-\" 2 года\"")
//    @Test
//    public void creditFalseYoungBirthday() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputBirthday(youngDateString)
//                .checkBirthday(birthdayCaptionYoung);
//    }
//
//    @DisplayName("Ввод в поле \"Электронная почта\" одного символа")
//    @Test
//    public void creditFalseEmail() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputEmail(testEmail)
//                .checkEmail(emailCaption);
//    }
//
//    @DisplayName("Проверка отправки заявки без галочки \"Я согласен с условиями рассмотрения заявки\"")
//    @Test
//    public void creditAllowConditions() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.allowConditions()
//                .clickButtonNext()
//                .checkAllow(conditionCaption);
//    }
//
//    @DisplayName("Ввод пробела в поле \"Сумма\"")
//    @Test
//    public void creditSumSpace() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputSumCredit(testSum1)
//                .checkSumCredit(sumMin);
//    }
//
//    @DisplayName("Ввод в поле \"Сумма\" большого числа")
//    @Test
//    public void creditSumBig() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputSumCredit(testSum2)
//                .checkSumCredit(sumMax);
//    }
//
//    @DisplayName("Ввод в поле \"Срок\" пробел")
//    @Test
//    public void creditTimeBig() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputTimeCredit(testTime1)
//                .checkTimeCredit(timeMin);
//    }
//
//    @DisplayName("Ввод в поле \"Срок\" большого числа")
//    @Test
//    public void creditTimeSpace() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputSumCredit(testTime2)
//                .checkTimeCredit(timeMax);
//    }
//
//    @DisplayName("Ввод в поле \"Мобильный телефон\" одной цифры")
//    @Test
//    public void creditPhoneOneNumber() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputPhone(phoneTest)
//                .checkPhone(phoneCaptionFalse);
//    }
//
//    @DisplayName("Отправка заявки с корректными данными")
//    @Test
//    public void creditTrue() {
//        homeBankPage.openHomeBankPage()
//                .clickCredit();
//
//        creditPage.clickArrange();
//
//        creditCashPage.inputData(trueData)
//                .inputBirthday(trueDateString)
//                .inputEmail(trueEmail)
//                .goalCredit()
//                .inputPhone(truePhone)
//                .inputPhoneCode(num1, num2, num3, num4)
//                .checkFalseCode(codeFalse);
//    }

}
