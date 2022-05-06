package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class MyProfileScreen extends BasePage {

    /*Variable repository*/
    private final By email = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_email']");
    private final By phone = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_phone']");
    private final By editBtn = By.className("android.widget.ImageView");
    private final By emailTxt = By.xpath("//android.widget.EditText[@resource-id='com.reeftechnology.reef.mobile:id/edit_email']");
    private final By saveBtn = By.xpath("//android.widget.Button[@text='SAVE']");
    private final By navigateBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

    /*Actions*/
    public String getEmail() {

        return getText(email, WaitStrategy.PRESENCE);
    }

    public String getPhone() {

        return getText(phone, WaitStrategy.PRESENCE);
    }

    public void clickEditBtn() throws InterruptedException {
        doClickElementFromList(editBtn, 0);
    }

    public void editEmail(String text) {
        doSendKeys(emailTxt, text, WaitStrategy.PRESENCE);
        doClick(saveBtn, WaitStrategy.CLICKABLE);
        doClick(navigateBtn, WaitStrategy.CLICKABLE);

    }

}
