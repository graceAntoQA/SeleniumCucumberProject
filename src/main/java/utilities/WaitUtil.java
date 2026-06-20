package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
    WebDriver driver;
    //constructor
    public WaitUtil(WebDriver driver){
        this.driver=driver;
    }
    public void waitForElement(WebElement element,long timeOut){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
