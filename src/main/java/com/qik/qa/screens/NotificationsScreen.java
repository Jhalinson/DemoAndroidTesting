package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.factories.ActionsFactory;
import org.openqa.selenium.By;

public class NotificationsScreen extends BasePage {

    /*Variable repository*/
    private final By showNotificationsOn = By.xpath("//android.widget.LinearLayout[@content-desc=\"Notifications, Show notifications, On, Switch\"]/android.widget.Switch");
    private final By showNotificationsOff = By.xpath("//android.widget.Switch[@resource-id='com.android.settings:id/switch_widget']");
    private final By appIconBadgesOn = By.xpath("//android.widget.Switch[@resource-id='android:id/switch_widget']");
    private final By appIconBadgesOff = By.xpath("//android.widget.Switch[@resource-id='android:id/switch_widget']");

    /*Actions*/
    public void clickShowNotifications() throws InterruptedException {
        Thread.sleep(3000);
        ActionsFactory.tapByElement(showNotificationsOn);
    }

    public void clickAppIconBadges() {
        ActionsFactory.tapByElement(appIconBadgesOn);
    }

    public boolean validateShowNotificationsOnSwitch() {

        System.err.println("switch in notification page::   " + getStateSwitch(showNotificationsOn));

        return getStateSwitch(showNotificationsOn);
    }

    public boolean validateShowNotificationsOffSwitch() {
        System.err.println("switch in notification page::   " + getStateSwitch(showNotificationsOff));
        return getStateSwitch(showNotificationsOff);
    }

    public boolean validateAppIconBadgesOnSwitch() {
        System.out.println("switch in app icon badge page::   " + getStateSwitch(appIconBadgesOn));
        return getStateSwitch(appIconBadgesOn);
    }

    public boolean validateAppIconBadgesOffSwitch() {
        System.out.println("switch in app icon badge page::   " + getStateSwitch(appIconBadgesOff));
        return getStateSwitch(appIconBadgesOff);
    }

}
