package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class FQAScreen extends BasePage {

    /*Variable repository*/
    private By emailInp = By.xpath("//android.view.View[@text='REEF™ Mobile Help']");
    private By fAQBtns = By.className("android.widget.Button");

    /*Actions*/
    public String getFAQBtnText(String text) {
        return getTextFromMultipleElements(fAQBtns, text);
    }

    public String getFAQText() {
        return getText(emailInp, WaitStrategy.PRESENCE);
    }

}
