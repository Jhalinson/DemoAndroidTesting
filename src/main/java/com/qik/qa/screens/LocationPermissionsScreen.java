package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class LocationPermissionsScreen extends BasePage {

    /*Variable repository*/
    private final By locationsPermissionsOtions = By.className("android.widget.LinearLayout");
    private final By denyOptions = By.xpath("//android.widget.RadioButton[@resource-id='com.android.permissioncontroller:id/deny_radio_button']");
    private final By askEveryOptions = By.xpath("//android.widget.RadioButton[@resource-id='com.android.permissioncontroller:id/deny_radio_button']");
    private final By backBtn = By.xpath("//android.widget.ImageButton[@content-desc='Back']");

    /*Actions*/
    public void clickAllowOnlyWhile() throws InterruptedException {
        doClickElementFromList(locationsPermissionsOtions, 0);
    }

    public void clickBackBtn() {

        doClick(backBtn, WaitStrategy.CLICKABLE);
    }


    public void clickAskEveryTime() throws InterruptedException {
        doClickElementFromList(locationsPermissionsOtions, 1);
    }

    public void clickDeny() throws InterruptedException {
        doClickElementFromList(locationsPermissionsOtions, 2);
    }
}
