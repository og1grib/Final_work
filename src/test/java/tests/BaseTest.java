package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;


public abstract class BaseTest {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Selenide.clearBrowserCookies();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1440x900";
        Configuration.timeout = 100000;
        Configuration.pageLoadTimeout = 100000;
        Configuration.baseUrl = "http://localhost:8080";
    }

    @After
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
