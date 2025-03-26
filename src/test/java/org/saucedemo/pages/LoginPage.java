package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.saucedemo.utils.FieldUtils;

public class LoginPage extends BasePage {

    private final By usernameField = By.xpath("//input[@id='user-name']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton   = By.xpath("//input[@id='login-button']");
    private final By errorMessage  = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clearUsername() {
        FieldUtils.clearFieldByRepeatedlyDeleting(driver, usernameField);

    }

    public void clearPassword() {
        FieldUtils.clearFieldByRepeatedlyDeleting(driver, passwordField);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
