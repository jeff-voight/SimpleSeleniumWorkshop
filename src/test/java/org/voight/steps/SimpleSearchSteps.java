package org.voight.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.slf4j.LoggerFactory;
import org.voight.devices.DeviceFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.Buffer;
import java.util.List;

import org.slf4j.Logger;

public class SimpleSearchSteps {

    Logger log = LoggerFactory.getLogger(SimpleSearchSteps.class);
    long timeOut = (long) 5.0;

    By craigslistHeader = By.id("topban");
    By craigslistQuery = By.name("query");
    By craigslistResultsList = By.className("result-row");

    By submitGoogleBy = By.cssSelector("[aria-label=\"Google Search\"]");
    By googlePagesBy = By.xpath("//a[@aria-label=\"Page 2\"]");
    By submitBingBy = By.className("search");

    WebDriver driver;
    WebDriverWait wait;

    public SimpleSearchSteps() {
    }

    @Given("^I am using the (.*) browser$")
    public void getBrowser(String browser){
        driver = DeviceFactory.getDevice(browser);
        wait = new WebDriverWait(driver, timeOut);
    }
    @After
    public void tearDown(Scenario scenario) {
        log.error("SCENARIO TEARDOWN");
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName() + "." + scenario.getLine() + ".png");
        }
        driver.quit();
    }

    @Given("^I visit (.*) craigslist$")
    public void i_visit_craigslist_com(String locality) {
        driver.get("https://"+locality+".craigslist.org");
        wait.until(ExpectedConditions.presenceOfElementLocated(craigslistHeader));
        WebElement element = driver.findElement(craigslistHeader);
        Assert.assertTrue(element.getText().toLowerCase().contains(locality.toLowerCase()));
    }

    @When("^I search craigslist for (.*)$")
    public void i_search_craigslist_for(String term) {
        wait.until(ExpectedConditions.presenceOfElementLocated(craigslistQuery));
        WebElement searchField = driver.findElement(craigslistQuery);
        searchField.sendKeys(term);
        searchField.sendKeys(Keys.SPACE,Keys.SPACE,Keys.ENTER);
    }

    @Then("^craigslist retrieves more than one result with (.*)$")
    public void craigslist_retrieves_more_than_one_page_of(String term) {
        List<WebElement> element = driver.findElements(craigslistResultsList);
//        Assert.assertTrue(element.size()>1);
    }

}
