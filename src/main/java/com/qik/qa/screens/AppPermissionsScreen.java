package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import org.openqa.selenium.By;

public class AppPermissionsScreen extends BasePage {

    /*Variable repository*/
    private final By appPermissionsOtions = By.className("android.view.ViewGroup");
    private final By location = By.xpath("//android.widget.TextView[contains(@text, 'Location')]");
    private final By deniedText = By.xpath("//android.widget.TextView[contains(@text, 'DENIED')]");
    private final By removePermissionsOption = By.xpath("//android.widget.TextView[contains(@text, 'Remove permissions')]");
    private final By removePermissionsSwitchOn = By.xpath("//android.widget.Switch[@resource-id='android:id/switch_widget']");
    private final By removePermissionsSwitchOff = By.xpath("//android.widget.Switch[@resource-id='android:id/switch_widget']");

    /*Actions*/
    public String getDeniedText() {
        return getText(deniedText, WaitStrategy.VISIBLE);
    }

    public void clickLocation() throws InterruptedException {
        doClick(location, WaitStrategy.PRESENCE);
    }

    public void clickPushNotifications() throws InterruptedException {
        doClickElementFromList(appPermissionsOtions, 2);
    }

    public void clickRemovePermissionsOption() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByElement(removePermissionsOption);
    }

    public boolean getRemovePermissionsSwitchOnState() {
        return getStateSwitch(removePermissionsSwitchOn);
    }

    public boolean getRemovePermissionsSwitchOffState() {
        return getStateSwitch(removePermissionsSwitchOff);
    }

}
