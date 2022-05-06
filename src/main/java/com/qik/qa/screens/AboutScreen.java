package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import org.openqa.selenium.By;

public class AboutScreen extends BasePage {

    /*Variable repository*/
    private final By fAQ = By.className("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_version_label']");
    private final By contactUs = By.className("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_contact_us']");
    private final By sendUsFeedback = By.className("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_send_feed_back']");
    private final By endUserLicense = By.xpath("//android.widget.TextView[@text='End User License Agreement']");
    private final By privacyNotice = By.xpath("//android.widget.TextView[@text='Privacy Notice']");
    private final By endUserLicenseAgreementDoc = By.xpath("//android.view.View[@text='REEF™ Mobile End User License Agreement']");
    private final By privacyNoticeDoc = By.xpath("//android.view.View[@text='REEF™ Mobile Privacy Notice']");

    /*Actions*/
    public void clickEndUserLicenseAgreement() {
        doClick(endUserLicense, WaitStrategy.CLICKABLE);
    }

    public void clickPrivateNotice() {
        doClick(privacyNotice, WaitStrategy.CLICKABLE);
    }

    public String getEndUserLicenseAgreementDoc(String text) {
        return getTextFromMultipleElements(endUserLicenseAgreementDoc, text);
    }

    public String getPrivateNoticeDoc(String text) {
        return getTextFromMultipleElements(privacyNoticeDoc, text);
    }

    public void clickFAQ() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByElement(fAQ);
    }

    public void clickContactUs() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByElement(contactUs);

    }

    public void clickSendUsFeedbacke() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByElement(sendUsFeedback);

    }

}
