package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    //created one method which actually pulls out driver.findelement
    public WebDriver driver;
    By career = By.cssSelector("#menu-item-21643");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCareer() throws InterruptedException {
        return driver.findElement(career);
    }

}


