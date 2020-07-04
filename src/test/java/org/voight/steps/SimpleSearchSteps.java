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

    By googleIconBy = By.id("hplogo");
    By searchGoogleBy = By.name("q");
    By submitGoogleBy = By.name("btnK");
    By googleLogoBy = By.id("logo");
    By googlePagesBy = By.xpath("//a[@aria-label=\"Page 2\"]");

    By bingIconBy = By.id("b_logo");
    By searchBingBy = By.id("sb_form_q");
    By submitBingBy = By.className("search");
    By bingLogoBy = By.className("b_logoArea");
    By bingPagesBy = By.className("b_pag");
    WebDriver driver;
    WebDriverWait wait;

    public SimpleSearchSteps() {
        log.info("Creating Browser.");
        driver = DeviceFactory.getDevice("Firefox");
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
        if (scenario.isFailed()) {
            Assert.fail("Scenario failed. See the screenshot below.");
        }
    }

    @Given("^I visit google\\.com$")
    public void i_visit_google_com() {
        driver.get("https://www.google.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(googleIconBy));
    }

    @When("^I search google for (.*)$")
    public void i_search_for(String term) {
        WebElement searchField = driver.findElement(searchGoogleBy);
        searchField.sendKeys(term);
        WebElement submitButton = driver.findElement(submitGoogleBy);
        submitButton.click();
    }

    @Then("^google retrieves more than one page of (.*)$")
    public void google_retrieves_more_than_one_page_of(String term) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(googleLogoBy));
        List<WebElement> elements = driver.findElements(googlePagesBy);
        log.info("There are " + elements.size() + " (hopefully 1) elements matching page 2");
        Assert.assertEquals(1, elements.size());
    }

    @Given("^I visit bing\\.com$")
    public void i_visit_bing_com() {
        driver.get("https://www.bing.com");
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(bingIconBy));
    }

    @When("^I search bing for (.*)$")
    public void i_search_bing_for(String term) {
        WebElement searchField = driver.findElement(searchBingBy);
        WebElement submitButton = driver.findElement(submitBingBy);
        Assert.assertTrue(submitButton.isDisplayed());
        searchField.sendKeys(term);
        submitButton.click();
    }

    @Then("^bing retrieves more than one page of (.*)$")
    public void bing_retrieves_more_than_one_page_of(String term) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(bingLogoBy));
        List<WebElement> elements = driver.findElements(bingPagesBy);
        log.info("There are " + elements.size() + " (hopefully 1) elements matching page 2");
        Assert.assertTrue(elements.size() == 1);
    }

}
