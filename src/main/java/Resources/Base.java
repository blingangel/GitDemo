package Resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public Properties prop;

    public WebDriver InitializeDriver() throws IOException {

        //chrome
        prop = new Properties();


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Academy/data.properties");
        prop.load(fis);

//        String browserName=System.getProperty("browser");

        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver","/Users/machouse/Downloads/chromedriver/chromedriver");
            ChromeOptions options = new ChromeOptions();

            if(browserName.contains("headless")) {
                options.addArguments("headless");

            }
            driver = new ChromeDriver(options);
        }
        else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();

        }
        else if (browserName.equals("IE")) {
            driver = new InternetExplorerDriver();

        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;






    }

    public String getScreenShotPath(String testMethod, WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String destFile = System.getProperty("user.dir")+"//reports//" +testMethod+".png";
        FileUtils.copyFile(source,new File(destFile));
        return destFile;
    }

}
