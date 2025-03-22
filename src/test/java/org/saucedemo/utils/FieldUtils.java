package org.saucedemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FieldUtils {

    public static void clearFieldBySelectingAndDeleting(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
    }

    public static void clearFieldByRepeatedlyDeleting(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        String currentValue = element.getDomAttribute("value");
        int length = currentValue != null ? currentValue.length() : 0;

        for (int i = 0; i < length; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
}
