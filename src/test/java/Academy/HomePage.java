package Academy;

import PageObject.ForgotPassword;
import PageObject.LandingPage;
import PageObject.LogingPage;
import Resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends Base {
    public WebDriver driver;


    public static Logger Log = LogManager.getLogger(Base.class.getName());


    @BeforeTest
    public void openBrowser() throws IOException {
        driver=InitializeDriver();
        driver.get("http://qaclickacademy.com");
    }


    @Test(dataProvider="getData")
    public void basePageNavigation(String Username, String Password, String Text) throws IOException {
    driver.get(prop.getProperty("url"));
        LandingPage l = new LandingPage(driver);
        LogingPage lp=l.getLogIn();
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
        System.out.println(Text);

        Log.info(Text);

        lp.submitButton().click();
        ForgotPassword fp = lp.forgotPassword();
        fp.getEmail().sendKeys("abczxj");
        fp.sendInstruction().click();





    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][3];
        data[0][0]="abcdefg@gmail.com";
        data[0][1]="asdqa";
        data[0][2]="Restricted User";

        data[1][0]="restrcited@gmail.com";
        data[1][1]="srdq3";
        data[1][2]="Non restricted user";

        return data;


    }

    @AfterTest
    public void shutDown() {
        driver.close();
    }



}
