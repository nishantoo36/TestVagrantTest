package manager.UI;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;


public class DriverFactor {

    private WebDriver driver;
    private String browser;
    private boolean isWebDriverRequired;

    public DriverFactor() {
        browser = FileReaderManager.getInstance().getConfigReader().getBrowserName();
        isWebDriverRequired= FileReaderManager.getInstance().getConfigReader().getDriverRequirement();
    }

    public WebDriver getDriver() {
        if(isWebDriverRequired) {
            if (driver == null)
                driver = startDriver();
        }
        return driver;
    }

    private WebDriver startDriver() {
        if ("Chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(false);
            options.addArguments("--disable-notifications");
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if ("FireFox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;

    }

    public void closeDriver() {
        driver.quit();
    }


}
