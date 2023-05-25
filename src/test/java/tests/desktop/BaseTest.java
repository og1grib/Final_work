package tests.desktop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;


public abstract class BaseTest {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

//    @BeforeEach //для локальной работы
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        Selenide.clearBrowserCookies();
//        Configuration.browser = "chrome";
//        Configuration.driverManagerEnabled = true;
//        Configuration.browserSize = "1440x900";
//        Configuration.timeout = 50000;
//        Configuration.pageLoadTimeout = 50000;
//    }

    @BeforeEach //для работы на виртуальной машине
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Selenide.clearBrowserCookies();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 50000;
        Configuration.pageLoadTimeout = 50000;
        Configuration.remote = "http://localhost:4444/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\",\"--remote-debugging-port=9222\"");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }


    @AfterEach
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
