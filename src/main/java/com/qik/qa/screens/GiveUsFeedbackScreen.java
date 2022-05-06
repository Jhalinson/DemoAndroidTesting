package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class GiveUsFeedbackScreen extends BasePage {

    /*Variable repository*/
    private By reportBugOption = By.className("//android.widget.TextView[@text='Report a bug']");
    private By requestFeatureOption = By.xpath("//android.widget.TextView[@text='Request a feature']");
    private final By askQuestionOption = By.xpath("//android.widget.TextView[@text='Ask a question']");
    private final By sendToUsOption = By.xpath("//android.widget.TextView[@text='Send to us through form' and @resource-id='com.reeftechnology.reef.mobile:id/tv_send_us_through_form']");

    /*Actions*/
    public void clickReportBug() throws InterruptedException {
        doClick(reportBugOption, WaitStrategy.CLICKABLE);
    }

    public void clickRequestFeature() throws InterruptedException {
        doClick(requestFeatureOption, WaitStrategy.CLICKABLE);
    }

    public void clickAskQuestion() throws InterruptedException {
        doClick(askQuestionOption, WaitStrategy.CLICKABLE);
    }

    public void clickSendUsFeedback() throws InterruptedException {
        doClick(sendToUsOption, WaitStrategy.CLICKABLE);
    }

}
