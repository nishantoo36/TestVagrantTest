package ActionClasses.UI;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utility.SeleniumUtility;

import java.util.List;

public class HomePage extends SeleniumUtility {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "h_sub_menu")
    WebElement moreIcon;

    @FindAll(value = {@FindBy(xpath = "//div[@class='topnav_cont']/child::a")})
    List<WebElement> headerMenus;


    public boolean isUserOnHomePage(String pageTitle,int timeout) {
        return isTitle(pageTitle,timeout);
    }

    public boolean isMenuAvailableInHeader(String menu,int wait)  {
        return getAllElementsTextFromElementList(headerMenus,wait).contains(menu.toUpperCase());
    }

    public void clickOnMenu(String menu,int wait)  {
        try {
            if (!isMenuAvailableInHeader(menu,wait)) {
                clickOnElement(moreIcon, 0);
            }
            clickOnElement(getElementByTextFromElementList(headerMenus,menu,0),0);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            throw  new NoSuchElementException( menu+ " is not available i header");
        }
    }

}

