package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class MyAccountScreen extends BasePage {

    /*Variable repository*/
    private final By myProfile = By.xpath("//android.widget.CheckedTextView[@text='My Profile']");
    private final By myVehicles = By.xpath("//android.widget.CheckedTextView[@text='My Vehicles']");
    private final By billing = By.xpath("//android.widget.CheckedTextView[@text='Billing']");
    private final By settings = By.xpath("//android.widget.CheckedTextView[@text='Settings']");
    private final By inviteFriends = By.xpath("//android.widget.CheckedTextView[@text='Invite Friends']");
    private final By giveUsFeedback = By.xpath("//android.widget.CheckedTextView[@text='Give Us Feedback']");
    private final By rateOurApp = By.xpath("//android.widget.CheckedTextView[@text='Rate Our App']");
    private final By about = By.xpath("//android.widget.CheckedTextView[@text='About']");
    private final By help = By.xpath("//android.widget.CheckedTextView[@text='Help']");
    private final By logout = By.xpath("//android.widget.CheckedTextView[@text='Logout']");

    /*Actions*/
    public void clickMuAccountLinks() {
        doClick(myProfile, WaitStrategy.CLICKABLE);
        doClick(myVehicles, WaitStrategy.CLICKABLE);
        doClick(billing, WaitStrategy.CLICKABLE);
        doClick(settings, WaitStrategy.CLICKABLE);
        doClick(inviteFriends, WaitStrategy.CLICKABLE);
        doClick(giveUsFeedback, WaitStrategy.CLICKABLE);
        doClick(rateOurApp, WaitStrategy.CLICKABLE);
        doClick(about, WaitStrategy.CLICKABLE);
        doClick(help, WaitStrategy.CLICKABLE);

    }

    public void clickMyProfile() {
        doClick(myProfile, WaitStrategy.CLICKABLE);
    }

    public void clickMyVehicles() {
        doClick(myVehicles, WaitStrategy.CLICKABLE);
    }

    public void clickLogOut() {
        doClick(logout, WaitStrategy.CLICKABLE);
    }

    public void clickBilling() {
        doClick(billing, WaitStrategy.CLICKABLE);
    }

    public void clickSettings() {
        doClick(settings, WaitStrategy.CLICKABLE);
    }

    public void clickInviteFriends() {
        doClick(inviteFriends, WaitStrategy.CLICKABLE);
    }

    public void clickGiveUsFeedback() {
        doClick(giveUsFeedback, WaitStrategy.CLICKABLE);
    }

    public void clickAbout() {
        doClick(about, WaitStrategy.CLICKABLE);
    }

    public void clickHelp() {
        doClick(help, WaitStrategy.CLICKABLE);
    }

    public void clickRateOurApp() {
        doClick(rateOurApp, WaitStrategy.CLICKABLE);

    }

}
