package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobsPage {
    public WebDriver driver;

    By filterLocation = By.cssSelector("select.jobs-locations");
    By filterDepartment = By.cssSelector("select.jobs-teams");
    By jobsList = By.xpath("//div[@class='jobs-list'] /a");
    By PositionList = By.xpath("//div[@class='jobs-list'] /a/span[1]");
    By DepartmentList = By.xpath("//div[@class='jobs-list'] /a/span[2]");
    By LocationList = By.xpath("//div[@class='jobs-list'] /a/span[3]");
    By qaJob = By.xpath("//a[@class='job QualityAssurance Istanbul,Turkey Full-Time'][1]");

    public JobsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement filterByLocation() {
        return driver.findElement(filterLocation);
    }

    public WebElement filterByDepartment() {
        return driver.findElement(filterDepartment);
    }

    public List<WebElement> getJobsList() {
        return driver.findElements(jobsList);
    }

    public List<WebElement> getPositionList() {
        return driver.findElements(PositionList);
    }

    public List<WebElement> getDepartmentList() {
        return driver.findElements(DepartmentList);
    }

    public List<WebElement> getLocationList() {
        return driver.findElements(LocationList);
    }

    public WebElement SeniorQAJob() {
        return driver.findElement(qaJob);
    }
}
