package org.saucedemo.core;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public static void initDriver() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        String browser = System.getProperty("browser", "edge");
        if (driver.get() == null) {
            switch (browser.toLowerCase()) {
                case "firefox" -> {
                    var Options = new FirefoxOptions();
                    if (headless) {
                        Options.addArguments("--headless");
                        Options.addArguments("--disable-gpu");
                    }

                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver(Options));
                }
                case "edge" -> {
                    var Options = new EdgeOptions();
                    if (headless) {
                        Options.addArguments("--headless");
                        Options.addArguments("--disable-gpu");
                    }
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver(Options));
                }
                default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.get().manage().window().maximize();
            logger.info("Driver initialized for thread: {} and browser: {}", Thread.currentThread().getId(), browser);

        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            logger.info("Driver quit for thread: {}", Thread.currentThread().getId());
        }
    }
}