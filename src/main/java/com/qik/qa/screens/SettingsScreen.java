package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class SettingsScreen extends BasePage {

    /*Variable repository*/
    private By appPermissions = By.id("com.reeftechnology.reef.mobile:id/tv_permissions");
    private By appPermissionsOptions = By.className("android.view.ViewGroup");

    /*Actions*/
    public void clickAppPermissions() {
        doClick(appPermissions, WaitStrategy.CLICKABLE);
    }

    public void clickLocationServices() throws InterruptedException {
        doClickElementFromList(appPermissionsOptions, 0);
    }
    public void clickPushNotifications() throws InterruptedException {
        doClickElementFromList(appPermissionsOptions, 1);
    }
}
