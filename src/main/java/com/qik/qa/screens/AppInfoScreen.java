package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.factories.ActionsFactory;
import org.openqa.selenium.By;

public class AppInfoScreen extends BasePage {

    /*Variable repository*/
    private By appInfoPageOptions = By.className("android.widget.LinearLayout");
    private By notifications = By.xpath("//android.widget.LinearLayout[@content-desc=\"Notifications, Show notifications, On, Switch\"]/android.widget.Switch");

    /*Actions*/
    public void clickNotifications() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByCoordinates(315, 450);
    }

    public void clickPermissions() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByCoordinates(350, 570);
    }

    public void clickAppTimer() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByCoordinates(260, 690);
    }

    public void clickSetAsDefault() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByCoordinates(350, 860);
    }
}
