package seleniumFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class Utilities {
    public WebDriver driver;
    By Frame = By.cssSelector("iframe.sp-fancybox-iframe.sp-fancybox-skin.sp-fancybox-iframe-959");

    public Utilities(WebDriver driver) {
        this.driver = driver;
    }

    public void handleCloseIcon() throws InterruptedException {
        WebElement frame = driver.findElement(By.cssSelector("iframe.sp-fancybox-iframe.sp-fancybox-skin.sp-fancybox-iframe-959"));
        WaitUntilEelement(By.cssSelector("iframe.sp-fancybox-iframe.sp-fancybox-skin.sp-fancybox-iframe-959"));
        Assert.assertTrue(frame.isDisplayed());
        driver.switchTo().frame(frame);
        driver.findElement(By.id("wrap-close-button-1613678167784")).click();
    }

    public void WaitUntilFrame() throws InterruptedException {

        WebElement framel = driver.findElement(By.cssSelector("iframe.sp-fancybox-iframe.sp-fancybox-skin.sp-fancybox-iframe-959"));
//        driver.switchTo().frame(framel);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

        WebElement frameElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(Frame);
            }
        });
    }

    public void WaitUntilElementLocat(WebElement element) throws InterruptedException {

        WebElement framel = driver.findElement(By.cssSelector("iframe.sp-fancybox-iframe.sp-fancybox-skin.sp-fancybox-iframe-959"));
//        driver.switchTo().frame(framel);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

        WebElement frameElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(Frame);
            }
        });
    }

    public void WaitUntilEelement(By Byelement) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(Byelement));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);


    }

    public Long CurrentScrollPosition() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long d = (Long) js.executeScript("return window.pageYOffset;");
        System.out.println("Scroll position after scrolling upto an element: " + d);
        return d;
    }


    public boolean checkIfElementIsVisible(WebElement element) {
        try {
            if (new WebDriverWait(driver, 6).until(ExpectedConditions.visibilityOf(element)) != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


}