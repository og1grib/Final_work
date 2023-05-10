package tests;

import org.junit.Test;
import pages.HomeBankPage;

public  class FirstTest extends BaseTest{
    HomeBankPage homeBankPage = new HomeBankPage();

    @Test
    public void cardMtsCashback() {
        homeBankPage.openHomeBankPage()
                .clickButtonCheckLimit()
                .checkNecessarilyFields()
                .inputPhoneField()
                .checkTruePhoneField()
                .inputDataField()
                .checkTrueDataField()
                .inputRandomPhoneData()
                .clickButtonCheckLimit()
                .checkCodeField();
//                .inputCode()
//                .checkTrueCode();
    }

}
