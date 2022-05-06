package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

public class SendUsFeedbackScreen extends BasePage {

    /*Variable repository*/
    private By emailTxt = By.xpath("//android.view.View[4]/android.widget.EditText");
    private static final By titleTxt = By.xpath("//android.view.View/android.view.View[7]/android.widget.EditText");
    private final By submitBtn = By.xpath("//android.widget.Button[@text='Submit' ]");
    private final By thankFeedbackText = By.xpath("//android.view.View[@text='Thank you for your feedback. Please press the back button to continue using REEF Mobile!']");

    /*Actions*/
    public void sendEmailTxt(String text) {

        doSendKeys(emailTxt, text, WaitStrategy.PRESENCE);
    }

    public void sendTitleTxt(String text) {

        doSendKeys(titleTxt, text, WaitStrategy.PRESENCE);

    }

    public void sendDescriptionTxt(String text) throws InterruptedException {
        List<AndroidElement> textFieldsList = DriverManager.getTlDriver().findElementsByClassName("android.widget.EditText");
        for (int i = 0; i < textFieldsList.size(); i++) {
            textFieldsList.get(i).sendKeys("Testing");
        }
        Thread.sleep(7000);


    }

    public void clickChecks() throws InterruptedException {

        ActionsFactory.tapByCoordinates(103, 1332);
        ActionsFactory.tapByCoordinates(179, 1379);
        ActionsFactory.tapByCoordinates(233, 1436);

        DriverManager.getTlDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

    }

    public void clickSubmitBtn() {
        DriverManager.getTlDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        doClick(submitBtn, WaitStrategy.CLICKABLE);

    }

    public String getThanksText() {

        return getText(thankFeedbackText, WaitStrategy.VISIBLE);
    }

}
