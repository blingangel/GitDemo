package Academy;

import PageObject.LandingPage;
import PageObject.LogingPage;
import Resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateTitle extends Base {
    public static Logger Log = LogManager.getLogger(Base.class.getName());
    public WebDriver driver;
    LandingPage l;

    @BeforeTest
    public void initialize() throws IOException {
        driver = InitializeDriver();
        Log.info("Driver is initialized");

        driver.get(prop.getProperty("url"));
        Log.info("Navatigated to Homepage");
    }

    @Test
    public void validateTitle() throws IOException {

        l = new LandingPage(driver);
        Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
        Log.info("Successfully validated text message");
        System.out.println("Test completed");




    }

    @Test
    public void validateHeader() throws IOException {

        Assert.assertEquals(l.getTitle().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");




    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }





}
