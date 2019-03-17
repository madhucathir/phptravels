package step_definitions;

import java.net.MalformedURLException;

import helpers.BrowserFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks{
    public static WebDriver driver;

    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
    	System.out.println("Called openBrowser");
    	driver = BrowserFactory.getDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().fullscreen();
    }

     
    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if(driver!=null) {
            if (scenario.isFailed()) {
                try {

                    scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image/png");
                } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                    System.err.println(somePlatformsDontSupportScreenshots.getMessage());
                }

            }
            //driver.quit();
        }
        
    }
    
}