package StepDefinitions;

import PageObject.LandingPage;
import PageObject.LogingPage;
import PageObject.PortalHomepage;
import Resources.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class stepDefinition extends Base {

    @Given("Initialize the browser with Chrome")
    public void InitializeBrowserWithChrome() throws IOException {
        driver = InitializeDriver();
    }

    @When("Navigate to {string} site")
    public void navigateToSite(String arg0) {
        driver.get(arg0);

    }

    @Then("Click on Login link in home page to sign in")
    public void clickOnLoginLinkInHomePageToSignIn() {
        LandingPage l = new LandingPage(driver);
        if (l.getPopupSize()>0) {
            l.getPopup().click();
        }
        l.getLogIn();
    }

//    @And("Enter {string} and {string} and logs in")
//    public void enterAndAndLogsIn(String arg0, String arg1) {
//        LogingPage lp = new LogingPage(driver);
//        lp.getEmail().sendKeys(arg0);
//        lp.getPassword().sendKeys(arg1);
//        lp.submitButton().click();
//
//    }

    @Then("Verify that user is successfully logged in")
    public void verifyThatUserIsSuccessfullyLoggedIn() {
        PortalHomepage ph = new PortalHomepage(driver);
        Assert.assertTrue(ph.getSearchBox().isDisplayed());
    }

//    @And("Enter (.+) and (.+) and logs in")
//    public void enterUsernameAndPasswordAndLogsIn(String arg0, String arg1) {
//        LogingPage lp = new LogingPage(driver);
//        lp.getEmail().sendKeys(arg0);
//        lp.getPassword().sendKeys(arg1);
//        lp.submitButton().click();
//    }

    @And("Close browser")
    public void closeBrowser() {
        driver.quit();
    }

    @And("Enter {string} and {string} and logs in")
    public void enterAndAndLogsIn(String arg0, String arg1) {
        LogingPage lp = new LogingPage(driver);
        lp.getEmail().sendKeys(arg0);
        lp.getPassword().sendKeys(arg1);
        lp.submitButton().click();
    }
}
