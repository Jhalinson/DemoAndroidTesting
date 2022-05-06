package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import org.openqa.selenium.By;

public class BillingScreen extends BasePage {

    /*Variable repository*/
    private final By billingOptions = By.className("android.widget.TextView");

    /*Actions*/
    public void clickTransactions() throws InterruptedException {
        doClickElementFromList(billingOptions, 1);
    }

    public void clickWallet() throws InterruptedException {
        doClickElementFromList(billingOptions, 2);
        Thread.sleep(5000);
    }
}
