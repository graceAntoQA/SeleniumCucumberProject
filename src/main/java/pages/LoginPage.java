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

    @FindBy(id = "txt-email")
    WebElement usernameTextBox;

    @FindBy(id = "txt-password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[contains(text(),\"Login\")]")
    WebElement loginButton;

    @FindBy(xpath = "//span[@class=\"text-danger\"]")
    WebElement invalidLoginErrorText;

    @FindBy(xpath = "//h5[@class=\"mb-0\"]")
    WebElement acknowledgeText;



    //constructor to initialize driver
    public LoginPage(WebDriver driver) {
        this.driver=driver;

        PageFactory.initElements(driver, this);
        wait=new WaitUtil(driver);
    }
    //Click account icon
    public void clickAccountIcon(){
        accountIcon.click();
    }

    //Enter username
    public void setUserName(String strUserName) {
        usernameTextBox.sendKeys(strUserName);

    }

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
    public String getAcknowledgeText() {
        return acknowledgeText.getText();
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

