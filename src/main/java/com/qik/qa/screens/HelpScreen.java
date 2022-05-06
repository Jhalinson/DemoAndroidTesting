package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class HelpScreen extends BasePage {

    /*Variable repository*/
    private By fAQ = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_version_label']");
    private By contactUs = By.xpath("//android.widget.TextView[@text='Contact Us']");
    private final By sendUsFeedback = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.reeftechnology.reef.mobile:id/tv_send_feed_back')] ");

    /*Actions*/
    public void clickFaq() throws InterruptedException {
        doClick(fAQ, WaitStrategy.CLICKABLE);
        Thread.sleep(5000);
    }

    public void clickContactUs() throws InterruptedException {
        doClick(contactUs, WaitStrategy.CLICKABLE);
        Thread.sleep(5000);
    }

    public void clickSendUsFeedback() throws InterruptedException {
        doClick(sendUsFeedback, WaitStrategy.CLICKABLE);
        Thread.sleep(5000);
    }
}
