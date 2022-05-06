package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class EnterVerificationCodeScreen extends BasePage {

    /*Variable repository*/
    private final By verificationAlert = By.id("com.reeftechnology.reef.mobile:id/snackbar_text");
    private final By otpCode = By.xpath("//android.widget.FrameLayout/android.widget.TextView[1]");
    private final By continueBtn = By.xpath("//android.widget.Button[@text='Continue']");
    private final By incorrectVerificationCodeText = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/snackbar_text']");
    private final By somethingIsNotRightText = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/title']");
    private final By editPhoneLink = By.xpath("//android.widget.TextView[@text='Edit phone number']");

    /*Actions*/
    public String getOtpCode() {
        return getText(verificationAlert, WaitStrategy.VISIBLE);
    }

    public void sendOTPCode(String oTpCode) {
        doClick(otpCode, WaitStrategy.CLICKABLE);
        new Actions(DriverManager.getTlDriver()).sendKeys(oTpCode.substring(oTpCode.lastIndexOf(' ') + 1)).perform();
    }

    public void clickContinueBtn() {
        doClick(continueBtn, WaitStrategy.CLICKABLE);
    }


    public String getIncorrectVerificationCodeText() {
        return getText(incorrectVerificationCodeText, WaitStrategy.VISIBLE);
    }

    public String getSomethingIsNotRightText() {
        return getText(somethingIsNotRightText, WaitStrategy.VISIBLE);
    }

    public void clickEditPhoneLink() {
        doClick(editPhoneLink, WaitStrategy.CLICKABLE);
    }

}
