package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

     By login = By.cssSelector("a[href*='sign_in']");

     By title = By.cssSelector(".text-center>h2");

     public By naviBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

     By header = By.cssSelector("div[class*='video-banner'] h3");
     By popup = By.xpath("//button[text()='NO THANKS']");

    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }

    public LogingPage getLogIn() {
        driver.findElement(login).click();
        LogingPage lp = new LogingPage(driver);
        return lp;
    }

    public WebElement getTitle() { return driver.findElement(title);
    }

    public WebElement getBar() {
        System.out.println("bar navigating");
        return driver.findElement(naviBar); }

    public WebElement getHeader() {
        return driver.findElement(header);
    }

    public int getPopupSize() {
        return driver.findElements(popup).size();
    }

    public WebElement getPopup() {
        return driver.findElement(popup);
    }
}

