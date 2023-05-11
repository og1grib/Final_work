package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;

import java.time.Duration;

public abstract class BaseTest {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().clearDriverCache();
        Selenide.clearBrowserCookies();
//        Duration seconds = Duration.ofSeconds(100);
//        List<WebElement> options_under_resources = WebDriverManager.chromedriver().create().findElements(By.xpath("//*"));
//        WebDriverWait wait = new WebDriverWait(WebDriverManager.chromedriver().create(), seconds);
//        wait.until(ExpectedConditions.visibilityOfAllElements(options_under_resources));

//        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1440x900";
        Configuration.timeout = 100000;
//        Configuration.pageLoadTimeout = 100000;
        Configuration.baseUrl ="http://localhost:8080";
    }

    @After
    public void turnDown(){
        Selenide.closeWebDriver();
    }
}
