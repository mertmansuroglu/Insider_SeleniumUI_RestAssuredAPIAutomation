package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//div[@id='jobs-container'] //div
public class CareerPage {
    public WebDriver driver;
    By career = By.cssSelector("#menu-item-21643");
    By culture = By.xpath("//a[text()='CULTURE']");
    By cultureBlocks = By.xpath("//section[@class='grid-container']//div");
    By location = By.xpath("//a[text()='LOCATIONS']");
    By locationBlocks1 = By.xpath("//div[@class='col-sm-6'][1] //span");
    By locationBlocks2 = By.xpath("//div[@class='col-sm-6'][2] //span");
    //2
    By teams = By.xpath("//a[text()='TEAMS']");
    By teamsBlocks = By.xpath("//div[@class='row-bg-wrap instance-9'] //div");
    By jobs = By.xpath("//a[text()='JOBS']");
    By careerOp = By.xpath("//h2[text()='CAREER OPPORTUNITIES']");
    By jobsBlocks = By.xpath("//div[@id='jobs-container'] //div");
    By life = By.xpath("//a[text()='LIFE AT INSIDER']");
    By lifeBlocks = By.cssSelector(".vc_custom_heading.sec-title.vc_custom_1558338810286");

    public CareerPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCulture() {
        return driver.findElement(culture);
    }

    public WebElement getLocation() {
        return driver.findElement(location);
    }

    public WebElement getTeams() {
        return driver.findElement(teams);
    }

    public WebElement getJobs() {
        return driver.findElement(jobs);
    }

    public WebElement getcareerOp() {
        return driver.findElement(careerOp);
    }

    public WebElement getLife() {
        return driver.findElement(life);
    }

    public WebElement getlifeBlocks() {
        return driver.findElement(lifeBlocks);
    }

    public List<WebElement> getcultureBlocks() {
        return driver.findElements(cultureBlocks);
    }

    public List<WebElement> getlocationBlocks1() {
        return driver.findElements(locationBlocks1);
    }

    public List<WebElement> getlocationBlocks2() {
        return driver.findElements(locationBlocks2);
    }

    public List<WebElement> getteamsBlocks() {
        return driver.findElements(teamsBlocks);
    }

    public List<WebElement> getjobsBlocks() {
        return driver.findElements(jobsBlocks);
    }
}


//a[text()='Sign in to continue']