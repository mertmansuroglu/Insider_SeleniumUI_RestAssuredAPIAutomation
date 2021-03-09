package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import seleniumFramework.Base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hooks extends Base {

    @After("@Insider")
    public void embedScreenshot(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filename = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
            File targetFile = new File(System.getProperty("user.dir") + "--" + scenario.getName() + "--" + filename + ".png");
            FileHandler.copy(scrFile, targetFile);
        }
        driver.quit();


    }
}
