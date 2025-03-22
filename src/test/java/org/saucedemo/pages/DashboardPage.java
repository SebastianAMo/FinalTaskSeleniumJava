
package org.saucedemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private final WebDriver driver;
    private static final By title = By.xpath("//div[@class='app_logo']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        WebElement titleElement = driver.findElement(title);
        return titleElement.getText();
    }
}
