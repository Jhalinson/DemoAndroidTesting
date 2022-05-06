package com.qik.qa.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverManager {

    private static ThreadLocal<AndroidDriver<AndroidElement>> tlDriver = new ThreadLocal<>();

    public static AndroidDriver<AndroidElement> getTlDriver() {

        return tlDriver.get();
    }

    public static void setTlDriver(AndroidDriver<AndroidElement> androidDriver) {

        tlDriver.set(androidDriver);
    }

    public static void unLoad() {
        tlDriver.get().quit();
        tlDriver.remove();

    }

}
