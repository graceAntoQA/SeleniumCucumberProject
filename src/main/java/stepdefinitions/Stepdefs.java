package stepdefinitions;


import base.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import utilities.PropertyUtil;

import java.io.IOException;

//import static base.BaseClass.driver;

public class Stepdefs extends BaseClass {
   SoftAssert softAssert=new SoftAssert();
   LoginPage loginpage;


    @Before
    public void setup() throws IOException {
        String browser = PropertyUtil.fetchProperty("browser");
        initDriver(browser);
       // driver=getDriver();
        loginpage=new LoginPage(getDriver());
    }
    @Given("User launch Page")
    public void userLaunchPage() {

        getDriver().get("https://ecom.gotechmasters.com/");
    }

    @When("User enters {string} and {string}")
    public void userEntersAnd(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        loginpage.clickAccountIcon();
        String urlLogin= getDriver().getCurrentUrl();
        softAssert.assertEquals(urlLogin,"https://ecom.gotechmasters.com/login");
        loginpage.setUserName(username);
        loginpage.setPassword(password);
        Thread.sleep(2000);
        WebElement loginButton=loginpage.getLoginBtn();
        JavascriptExecutor js=(JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();", loginButton);
        //loginpage.clickLogin();
        Thread.sleep(2000);

    }

    @Then("error message displayed")
    public void errorMessageDisplayed() throws InterruptedException {
        String errorText=loginpage.getInvalidLoginErrorText();
        softAssert.assertEquals(errorText,"These credentials do not match our records.");
        Thread.sleep(2000);
        System.out.println("Verified invalid login");

    }

    @And("Exit from page")
    public void exitFromPage() {
       getDriver().quit();
    }

    @When("User enters Username and Password")
    public void userEntersUsernameAndPassword() {
        loginpage.clickAccountIcon();
        String urlLogin= getDriver().getCurrentUrl();
        softAssert.assertEquals(urlLogin,"https://ecom.gotechmasters.com/login");
       loginpage.setUserName("graceanto0099@gmail.com");
       loginpage.setPassword("India@2019");
        WebElement loginButton=loginpage.getLoginBtn();
        JavascriptExecutor js=(JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();", loginButton);

    }

    @Then("Successful message displayed")
    public void successfulMessageDisplayed() {
        String message=loginpage.getAcknowledgeText();
        softAssert.assertEquals(message,"Hello Grace Mary!");
        System.out.println("Verified valid login");

    }
}
