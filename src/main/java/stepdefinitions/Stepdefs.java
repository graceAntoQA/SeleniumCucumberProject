package stepdefinitions;


import base.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.PropertyUtil;

import java.io.IOException;

//import static base.BaseClass.driver;

public class Stepdefs extends BaseClass {
   LoginPage loginpage;

    @Before
    public void setup() throws IOException {
        String browser = PropertyUtil.fetchProperty("browser");
        initDriver(browser);
       // driver=getDriver();
        loginpage=new LoginPage(getDriver());
    }
    @Given("User is on Login Page")
    public void userIsOnLoginPage() {

        getDriver().get("https://ecom.gotechmasters.com/");
    }

    @When("User enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("error message displayed")
    public void errorMessageDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("Exit from page")
    public void exitFromPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("User enters Username and Password")
    public void userEntersUsernameAndPassword() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("Successful login message displayed")
    public void successfulLoginMessageDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
