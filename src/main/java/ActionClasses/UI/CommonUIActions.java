package ActionClasses.UI;

import com.cucumber.listener.Reporter;
import manager.FileReaderManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.SeleniumUtility;

public class CommonUIActions extends SeleniumUtility {
    public CommonUIActions(WebDriver driver) {
        super(driver);
    }
    int temp;

    @FindBy(className = "Allow")
    WebElement allowForAlert;

    public void openMainURL(int timeOutVal) {
            openUrl(FileReaderManager.getInstance().getConfigReader().getUrl(), timeOutVal);
    }

    public void acceptAlert(int timeOut) {
        if(isElementAvailable(allowForAlert,timeOut)) {
            clickOnElement(allowForAlert, timeOut);
        }
    }
}
