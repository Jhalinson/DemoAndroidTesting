package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import org.openqa.selenium.By;

public class TransactionsScreen extends BasePage {

    /*Variable repository*/
    private final By transactions = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reeftechnology.reef.mobile:id/rv_transactions']/android.view.ViewGroup");
    private final By detailTransaction = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reeftechnology.reef.mobile:id/rv_transactions']/android.view.ViewGroup");

    /*Actions*/
    public void clickDateTransactions() throws InterruptedException {
        doClickElementFromList(transactions, 0);
    }

    public void getDetailTransaction() throws InterruptedException {

        doClickElementFromList(detailTransaction, 0);

    }
}
