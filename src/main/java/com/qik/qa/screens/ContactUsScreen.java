package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class ContactUsScreen extends BasePage {

    /*Variable repository*/
    private final By email = By.xpath("//android.widget.TextView[@text='appsupport@reeftechnology.com']");
    private final By phone = By.xpath("//android.widget.TextView[@text='1-888-561-7333']");

    /*Actions*/
    public String getEmail() {
        return getText(email, WaitStrategy.VISIBLE);
    }

    public String getPhone() {
        return getText(phone, WaitStrategy.VISIBLE);
    }

}
