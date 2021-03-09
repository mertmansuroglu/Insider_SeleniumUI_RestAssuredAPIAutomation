package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.ApplyJobPage;
import pageObjects.CareerPage;
import pageObjects.JobsPage;
import pageObjects.LandingPage;
import seleniumFramework.Base;
import seleniumFramework.Utilities;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class InsiderTest extends Base {


    public static List<String> iStoreTheRequiredInfos() {
        JobsPage jp = new JobsPage(driver);
        List<WebElement> searchedJoBlist = driver.findElements(By.xpath("//div[@class='jobs-list'] /a"));
        String position = jp.getPositionList().get(0).getText();
        String department = jp.getDepartmentList().get(0).getText();
        String location = jp.getLocationList().get(0).getText();
        String url = searchedJoBlist.get(0).getAttribute("href");
        List<String> info = Arrays.asList(position, department, location, url);
        return info;
    }

    @When("I  visit insider web page")
    public void iVisitInsiderWebPage() {
        driver.get(prop.getProperty("url"));
    }

    @Then("I check if the page is correctly opened {string}")
    public void iCheckIfThePageIsCorrectlyOpened(String url) throws Exception {
        CareerPage cp = new CareerPage(driver);
        Thread.sleep(3000);
        try {
            Assert.assertEquals(url, driver.getCurrentUrl());

        } catch (Throwable pageNavigationError) {
            throw new Exception("navigated to wrong page");
        }

    }

    @Then("I check if the browser has been closed")
    public void iCheckIfTheBrowserHasBeenClosed() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }

    @When("I open career page")
    public void iOpenCareerPage() throws InterruptedException {
        driver.switchTo().defaultContent();
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        Thread.sleep(3000);
        try {
            lp.getCareer().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error on Page:element not found");
        }
        lp.getCareer().click();

    }

    @Then("I  should be able to handle the frame")
    public void iShouldBeAbleToHandleTheFrame() throws InterruptedException {
        Utilities ut = new Utilities(driver);
        ut.WaitUntilFrame();
        ut.handleCloseIcon();

    }

    @When("I open culture section")
    public void iOpenCultureSection() throws InterruptedException {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Thread.sleep(2000);
        try {
            cp.getCulture().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error on Page:element not found");
        }
        cp.getCulture().click();
    }

    @Then("I check if the culture blocks appeared")
    public void iCheckIfTheCultureBlocksAppeared() {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Assert.assertEquals(26, cp.getcultureBlocks().size());
    }

    @Then("I check current scroll position after scrolling to culture section {long}")
    public void iCheckCurrentScrollPositionAfterScrollingToCultureSection(Long d) throws InterruptedException {
        Utilities ut = new Utilities(driver);
        Thread.sleep(3000);
        System.out.println(ut.CurrentScrollPosition());
        Assert.assertEquals(ut.CurrentScrollPosition(), d);
    }

    @Then("I check if the location blocks appeared")
    public void iCheckIfTheLocationBlocksAppeared() {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Assert.assertEquals(25, cp.getlocationBlocks1().size());
        Assert.assertEquals(33, cp.getlocationBlocks2().size());
        System.out.println(ut.CurrentScrollPosition());
    }

    @When("I open location section")
    public void iOpenLocationSection() throws InterruptedException {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Thread.sleep(2000);
        try {
            cp.getLocation().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error on Page:element not found");
        }
        cp.getLocation().click();
    }

    @When("I open Teams section")
    public void iOpenTeamsSection() throws InterruptedException {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Thread.sleep(2000);
        try {
            cp.getLocation().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error on Page:element not found");
        }
        cp.getTeams().click();
    }

    @Then("I check if the Teams blocks appeared")
    public void iCheckIfTheTeamsBlocksAppeared() {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Assert.assertEquals(2, cp.getteamsBlocks().size());

    }

    @When("I open Jobs section")
    public void iOpenJobsSection() throws InterruptedException {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Thread.sleep(2000);
        try {
            cp.getLocation().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error on Page:element not found");
        }
        cp.getJobs().click();
    }

    @Then("I check if the Jobs blocks appeared")
    public void iCheckIfTheJobsBlocksAppeared() {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Assert.assertEquals(7, cp.getjobsBlocks().size());
    }

    @When("I open Life section")
    public void iOpenLifeSection() throws InterruptedException {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        Thread.sleep(2000);
        try {
            cp.getLocation().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error on Page:element not found");
        }
        cp.getLife().click();
    }

    @Then("I check if the Life blocks appeared")
    public void iCheckIfTheLifeBlocksAppeared() {
        LandingPage lp = new LandingPage(driver);
        Utilities ut = new Utilities(driver);
        CareerPage cp = new CareerPage(driver);
        cp.getlifeBlocks().isDisplayed();
    }

    @And("I filter jobs by Location - Istanbul, Turkey")
    public void iFilterJobsByLocationIstanbulTurkey() throws InterruptedException {
        JobsPage jp = new JobsPage(driver);
        Select sdropdown = new Select(jp.filterByLocation());
        sdropdown.selectByVisibleText("Istanbul, Turkey");
        Thread.sleep(3000);
    }

    @And("I filter jobs by department - Quality Assurance")
    public void iFilterJobsByDepartmentQualityAssurance() throws InterruptedException {
        JobsPage jp = new JobsPage(driver);
        Select sdropdown = new Select(jp.filterByDepartment());
        sdropdown.selectByVisibleText("Quality Assurance");
        Thread.sleep(3000);
    }

    @Then("I should see the search result")
    public void iShouldSeeTheSearchResult() {
        JobsPage jp = new JobsPage(driver);
        Utilities ut = new Utilities(driver);
        ut.checkIfElementIsVisible(jp.filterByLocation());
        Assert.assertEquals(4, jp.getJobsList().size());

    }

    @And("I scroll to Jobs page")
    public void iScrollToJobsPage() throws InterruptedException {
        CareerPage cp = new CareerPage(driver);
        WebElement element = cp.getcareerOp();
        Utilities ut = new Utilities(driver);
        ut.scrollToElement(element);
        Thread.sleep(4000);
    }

    @Then("I should see that all jobs position contains contains “Quality Assurance”")
    public void iShouldSeeThatAllJobsPositionContainsContainsQualityAssurance() {
        JobsPage jp = new JobsPage(driver);
        for (int i = 0; i < jp.getPositionList().size(); i++) {
            String name = jp.getPositionList().get(i).getText();
            try {
                name.contains("Quality Assurance");
            } catch (java.util.NoSuchElementException e) {
                Assert.fail("Error job position name");
            }
        }

    }

    @Then("I should see that all department contains contains “Quality Assurance”")
    public void iShouldSeeThatAllDepartmentContainsContainsQualityAssurance() throws InterruptedException {
        JobsPage jp = new JobsPage(driver);
        Thread.sleep(4000);
        for (int i = 0; i < jp.getPositionList().size(); i++) {
            String name = jp.getDepartmentList().get(i).getText();
            try {
                name.contains("Quality Assurance");
            } catch (java.util.NoSuchElementException e) {
                Assert.fail("Error job position name");
            }
        }


    }

    @Then("I should see that all location contains contains “Istanbul, Turkey”")
    public void iShouldSeeThatAllLocationContainsContainsIstanbulTurkey() {
        JobsPage jp = new JobsPage(driver);
        for (int i = 0; i < jp.getPositionList().size(); i++) {
            String name = jp.getLocationList().get(i).getText();
            try {
                name.contains("Istanbul, Turkey");
            } catch (java.util.NoSuchElementException e) {
                Assert.fail("Error job position name");
            }
        }
    }

    @When("I click Apply for this job button")
    public void iClickApplyForThisJobButton() throws InterruptedException {
        ApplyJobPage apj = new ApplyJobPage(driver);
        apj.getHeaderApplyButton().click();
        Thread.sleep(6000);
    }

    @Then("I check it redirects us to Application form page")
    public void iCheckItRedirectsUsToApplicationFormPage() {
        ApplyJobPage apj = new ApplyJobPage(driver);
        System.out.println(apj.applicationForm().isDisplayed());
//        Assert.assertTrue();
    }

    @And("I should see that presence of job description, requirements and Apply for this job button is valid for the opened job position")
    public void iShouldSeeThatPresenceOfJobDescriptionRequirementsAndApplyForThisJobButtonIsValidForTheOpenedJobPosition() {
        List<String> infos = iStoreTheRequiredInfos();
        JobsPage jp = new JobsPage(driver);
        jp.getJobsList().get(0).click();
        ApplyJobPage apj = new ApplyJobPage(driver);
        Assert.assertEquals(4, apj.getRequirements().size());
        String quality = apj.getCategories().get(1).getText().split("/")[0].trim();
        String locat = apj.getCategories().get(0).getText().split("/")[0].trim();
        String headline = apj.getHeadline().getText();
        Assert.assertTrue(headline.equalsIgnoreCase(infos.get(0)));
        Assert.assertTrue(quality.equalsIgnoreCase(infos.get(1)));
        Assert.assertTrue(locat.equalsIgnoreCase(infos.get(2)));
    }

    @Given("I open the browser {string}")
    public void iOpenTheChromeBrowser(String browsername) throws IOException {
        driver = driverInitialize(browsername);
    }
}
