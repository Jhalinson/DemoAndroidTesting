package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import org.openqa.selenium.By;

public class EmailScreen extends BasePage {

    /*Variable repository*/
    private By emailInp = By.id("com.reeftechnology.reef.mobile:id/edit_email");
    private final By check = By.className("android.widget.CheckBox");
    private final By continueBtn = By.xpath("//android.widget.Button[@text='Continue']");
    private final By validEmailMsj = By.xpath("//android.widget.TextView[@text='Please enter a valid email address']");
    private final By endUserLiceTxt = By.xpath("//android.widget.TextView[@text='I accept the End User License Agreement |']");
    private final By privateNoticeTxt = By.xpath("//android.widget.TextView[@text='Privacy Notice']");
    private final By licenseAgreementDoc = By.className("android.view.View");
    private final By mobilePrivacyNoticeDoc = By.className("android.view.View");
    private final By phoneLinkedAnotherEmailMsj = By.xpath("//android.widget.TextView[contains(text(),'Your phone number') or @resource-id='com.reeftechnology.reef.mobile:id/snackbar_text']");

    /*Actions*/
    public void sendEmail(String email) throws InterruptedException {
        doSendKeys(emailInp, email, WaitStrategy.PRESENCE);
        doClick(check, WaitStrategy.CLICKABLE);

    }

    public void clickContinueBtn() {
        doClick(continueBtn, WaitStrategy.CLICKABLE);
    }

    public String getValidEmailMessage() {
        System.out.println("MEsagge " + getTextFromMultipleElements(validEmailMsj, "Please enter a valid email address"));
        return getTextFromMultipleElements(validEmailMsj, "Please enter a valid email address");
    }

    public String getPhoneLinkedAnotherEmailMessage(String text) throws InterruptedException {
        return getTextFromMultipleElements(phoneLinkedAnotherEmailMsj, text);

    }

    public String getLicenseAgreementText() {
        return getText(endUserLiceTxt, WaitStrategy.PRESENCE);

    }

    public String getPrivacyNoticeText() {
        return getText(privateNoticeTxt, WaitStrategy.PRESENCE);

    }

    public String getEndUserDocText(String text) throws InterruptedException {
        Thread.sleep(3000);
        ActionsFactory.tapByCoordinates(362, 698);
        Thread.sleep(7000);
        return getTextFromMultipleElements(licenseAgreementDoc, text);
    }

    public String getMobilePrivacyDocText(String text) throws InterruptedException {
        Thread.sleep(3000);
        ActionsFactory.tapByCoordinates(131, 735);
        Thread.sleep(7000);
        return getTextFromMultipleElements(mobilePrivacyNoticeDoc, text);
    }

}
