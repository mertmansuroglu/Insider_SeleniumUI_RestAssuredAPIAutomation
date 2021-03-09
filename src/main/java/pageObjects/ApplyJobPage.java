package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApplyJobPage {
    public WebDriver driver;
    By requirements = By.cssSelector("ul.posting-requirements.plain-list");
    By categories = By.cssSelector(".posting-categories div");
    By headline = By.cssSelector("div.posting-headline h2");
    By headerApply = By.xpath("//div[@class='section page-centered posting-header'] //a[@class='postings-btn template-btn-submit shamrock']");
    By lastSectionApply = By.xpath("//div[@class='section page-centered last-section-apply'] //a[@class='postings-btn template-btn-submit shamrock']']");
    By resumeUpload = By.cssSelector("li.application-question.resume");
    By formPage = By.xpath("//form[@enctype='multipart/form-data']");

    public ApplyJobPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getRequirements() {
        return driver.findElements(requirements);
    }

    public List<WebElement> getCategories() {
        return driver.findElements(categories);
    }

    public WebElement getHeadline() {
        return driver.findElement(headline);
    }

    public WebElement getHeaderApplyButton() {
        return driver.findElement(headerApply);
    }

    public WebElement getBottomApplyButton() {
        return driver.findElement(lastSectionApply);
    }

    public WebElement applicationForm() {
        return driver.findElement(resumeUpload);
    }
}

