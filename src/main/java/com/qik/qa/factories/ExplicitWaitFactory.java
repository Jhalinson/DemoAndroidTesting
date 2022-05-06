package com.qik.qa.factories;

import com.qik.qa.constants.FrameworkConstants;
import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.WaitStrategy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory {
    static WebDriverWait wait;

    public ExplicitWaitFactory() {
        throw new IllegalStateException("Explicit Wait Factory Class Exception");
    }

    public static AndroidElement performExplicitWait(WaitStrategy waitStrategy, By locator) {
        AndroidElement element = null;

        try {
            if (waitStrategy == WaitStrategy.CLICKABLE) {
                element = (AndroidElement) new WebDriverWait(DriverManager.getTlDriver(),
                        FrameworkConstants.getExplicitWait()).until(ExpectedConditions.elementToBeClickable(locator));
            } else if (waitStrategy == WaitStrategy.PRESENCE) {
                element = (AndroidElement) new WebDriverWait(DriverManager.getTlDriver(),
                        FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.presenceOfElementLocated(locator));
            } else if (waitStrategy == WaitStrategy.VISIBLE) {
                element = (AndroidElement) new WebDriverWait(DriverManager.getTlDriver(),
                        FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.visibilityOfElementLocated(locator));
            } else if (waitStrategy == WaitStrategy.NONE) {

                element = DriverManager.getTlDriver().findElement(locator);
            }

        } catch (Exception e) {

            System.err.println("Selection click error: " + e.getCause() + e.getMessage() + e.getLocalizedMessage());

        }

        return element;
    }

    public static WebDriverWait explicitWait(int time) {

        wait = new WebDriverWait(DriverManager.getTlDriver(), time);
        return wait;
    }

}
