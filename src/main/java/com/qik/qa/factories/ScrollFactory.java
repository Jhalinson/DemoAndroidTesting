package com.qik.qa.factories;

import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.ScrollStrategy;
import io.appium.java_client.android.AndroidElement;

public class ScrollFactory {

    private ScrollFactory() {

    }

    public static AndroidElement performScroll(ScrollStrategy scrollStrategy, String resourceId, String text) {
        AndroidElement element = null;

        try {
            if (scrollStrategy == ScrollStrategy.SCROLLINTOVIEW) {

                element = (AndroidElement) DriverManager.getTlDriver()
                        .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId("
                                + resourceId + ")).scrollIntoView(" + "new UiSelector().text(" + text + "));");
                element.click();

            }
        } catch (Exception e) {
            e.getCause();
        }

        return element;
    }

}
