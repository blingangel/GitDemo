package Academy;

import PageObject.LandingPage;
import Resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateNaviBar extends Base {
    public WebDriver driver;
    public static Logger Log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = InitializeDriver();

        driver.get(prop.getProperty("url"));
    }

    @Test
    public void basePageNavigation() throws IOException {

        LandingPage l = new LandingPage(driver);

        driver.findElement(l.naviBar);
        Assert.assertTrue(l.getBar().isDisplayed());
        Log.info("Navigation bar is displayed");
        System.out.println("Test completed");


    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
