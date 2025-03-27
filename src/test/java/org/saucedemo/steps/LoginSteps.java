package org.saucedemo.steps;

import org.saucedemo.pages.DashboardPage;
import org.saucedemo.pages.LoginPage;
import org.saucedemo.core.DriverFactory;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginSteps {

    protected  WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    private LoginPage loginPage;

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: {}", scenario.getName());
        }
        DriverFactory.quitDriver();
    }


    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        logger.info("Navigated to the login page");
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        logger.info("Using username: {} and password: {}", username, password);
    }

    @When("I clear the username field")
    public void iClearUsernameAndPasswordFields() {
        loginPage.clearUsername();
        logger.info("Clearing username field");
    }

    @When("I clear the password field")
    public void iClearThePasswordField() {
        loginPage.clearPassword();
        logger.info("Clearing password field");
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
        logger.info("Login button clicked");
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedMessage) {
        String actual = loginPage.getErrorMessage();
        logger.info("Showing error message: {}", actual);
        MatcherAssert.assertThat(actual, containsString(expectedMessage));
    }

    @Then("I should see the title {string}")
    public void i_should_see_the_title(String string) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        String title = dashboardPage.getTitle();
        logger.info("Page title: {}", title);
        MatcherAssert.assertThat(title, is(string));
    }
}
