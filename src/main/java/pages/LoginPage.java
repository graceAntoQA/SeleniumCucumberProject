package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtil;

public class LoginPage {
    WebDriver driver;
    WaitUtil wait;
    @FindBy(xpath = "//*[contains(text(),'Account')]")
    WebElement accountIcon;

    @FindBy(css = "#password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement loginButton;

    @FindBy(css = "h3[data-test=\"error\"]")
    WebElement invalidLoginErrorText;

    //constructor to initialize driver
    public LoginPage(WebDriver driver) {
        this.driver=driver;

        PageFactory.initElements(driver, this);
        wait=new WaitUtil(driver);
    }

    //Enter username
    //public void setUserName(String strUserName) {
     //   usernameTextBox.sendKeys(strUserName);

    }
/*
    //Enter password
    public void setPassword(String strPassword) {
        passwordTextBox.sendKeys(strPassword);
    }

    //Get Login button
    public WebElement getLoginBtn() {
        return loginButton;
    }

    //Click Login
    public void clickLogin() {
        loginButton.click();
    }

    //Get error test
    public String getInvalidLoginErrorText() {
        return invalidLoginErrorText.getText();
    }

    public String getLoginBtnText() {
        return loginButton.getText();

    }
}
/*
public void clickLogin() {

    waitutil.waitForElement(loginButton,15);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,600)");
    js.executeScript("arguments[0].click();", loginButton);

}
*/

