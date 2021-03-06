package Utilities;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class SeleniumUtils extends TestBase {

    public static WebDriver driver;
    Logger logger = Logger.getLogger("OnlineShopping");

    public SeleniumUtils(WebDriver driver){
        this.driver = driver;
    }

    public void click(WebElement element){
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            String elementName = element.getText();
            element.click();
            logger.info(elementName+" Clicked");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void acceptAlert(){
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).accept();
            logger.info("Alert accepted");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendkeys(WebElement element, String input){
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(input);
            logger.info(input+" Entered");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getData(WebElement element) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
