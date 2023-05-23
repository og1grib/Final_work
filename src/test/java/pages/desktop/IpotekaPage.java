package pages.desktop;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IpotekaPage {
    private final static By BUTTON_PROGRAM = By.xpath("//div[text()= 'Программы']");
    private final static By ACCREDIT_BUILDERS = By.xpath("//a[@ href='/chastnim-licam/ipoteka/partners/#form']");

    public IpotekaPage clickProgram() {
        $(BUTTON_PROGRAM).shouldBe(Condition.visible).click();
        return this;
    }

    public IpotekaPage clickAccreditBuilders() {
        $(ACCREDIT_BUILDERS).click();
        return this;
    }

}
