package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class ReceiptScreen extends BasePage {

    /*Variable repository*/
    private final By detailTransactionInfo = By.xpath("//androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout");


    /*Actions*/
    public boolean getTransactionDetails() throws InterruptedException {
        Thread.sleep(5000);

        return getDisplayedImage(detailTransactionInfo, WaitStrategy.VISIBLE);

    }
}
