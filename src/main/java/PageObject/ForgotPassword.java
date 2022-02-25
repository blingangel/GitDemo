package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

    public WebDriver driver;

    By username = By.id("user_email");
    By password = By.id("user_password");
    By submit = By.name("commit");
    By forgotPS = By.cssSelector("[href*='password/new']");
    By instruction = By.cssSelector("[value='Send Me Instruction']");




    public ForgotPassword(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getEmail() {
        return driver.findElement(username);
    }
    public WebElement getPassword() { return driver.findElement(password); }
    public WebElement submitButton() { return driver.findElement(submit); }
    public WebElement sendInstruction() {return driver.findElement(instruction); }

}

