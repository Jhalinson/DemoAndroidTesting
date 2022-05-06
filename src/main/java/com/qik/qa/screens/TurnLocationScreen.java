package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import org.openqa.selenium.By;

public class TurnLocationScreen extends BasePage {

    /*Variable repository*/
    private final By notNowLink = By.xpath("//android.widget.TextView[@text='Not now']");

    /*Variable repository*/
    public void doClickNotNow() throws InterruptedException {
        doClick(notNowLink, WaitStrategy.CLICKABLE);

        ActionsFactory.tapByCoordinates(367, 1428);
        Thread.sleep(3000);

    }
}
