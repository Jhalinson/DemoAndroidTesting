package com.qik.qa.utils;

import com.qik.qa.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotsUtils {

    private ScreenshotsUtils() {

    }

    public static String getBase64Image() {


        return ((TakesScreenshot) DriverManager.getTlDriver()).getScreenshotAs(OutputType.BASE64);

    }

}
