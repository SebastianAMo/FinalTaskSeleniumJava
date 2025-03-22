package org.saucedemo.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.saucedemo.steps.LoginSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTest {

    protected  WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "edge");
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
        logger.info("Starting browser with driver: {}", browser);
    }

    @After
    public void tearDown() {
        logger.info("Closing browser");
        DriverFactory.quitDriver();
    }

}
