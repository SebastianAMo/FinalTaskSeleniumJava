
package org.saucedemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private static final By title = By.xpath("//div[@class='app_logo']");

    public DashboardPage(WebDriver driver) {
      super(driver);
    }

    public String getTitle() {
        WebElement titleElement = driver.findElement(title);
        return titleElement.getText();
    }
}
