package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomepage {

    public WebDriver driver;

    By searchBox = By.name("query");





    public PortalHomepage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    public ForgotPassword forgotPassword() {
        return new ForgotPassword(driver);

    }
}

