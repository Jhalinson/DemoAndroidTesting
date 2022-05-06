package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.WaitStrategy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class WelcomeScreen extends BasePage {

    /*Variable repository*/
    private final By phoneNumberInp = By.xpath("//android.widget.EditText[@text='Phone Number']");
    private final By continueBtn = By.xpath("//android.widget.Button[@text='Continue']");
    private final By contactLink = By.id("com.reeftechnology.reef.mobile:id/tv_contact_support");
    private final By invalidPhoneNumberText = By.className("android.widget.TextView");
    private final By countryChk = By.xpath("//*[@resource-id='com.reeftechnology.reef.mobile:id/spinner_country_picker']");
    private final By countryOptions = By.xpath("//android.widget.ListView[@resource-id='com.reeftechnology.reef.mobile:id/select_dialog_listview']/android.view.ViewGroup/android.widget.TextView");

    /*Variable repository*/
    public void clickCountryChk() {
        doClick(countryChk, WaitStrategy.CLICKABLE);
    }

    public String getDeviceName (){
        return DriverManager.getTlDriver().getCapabilities().getCapability("deviceName").toString();
    }

    public void getCountryText(String country) throws InterruptedException {
        doSelectOptionByText(countryOptions, country);
    }

    public void clickContinueBtn() {
        doClick(continueBtn, WaitStrategy.CLICKABLE);
    }

    public void sendPhoneNumber(String phoneNumber) {
        doSendKeys(phoneNumberInp, phoneNumber, WaitStrategy.PRESENCE);
    }

    public String getContactSupportText() {

        return getText(contactLink, WaitStrategy.VISIBLE);
    }

    public void clickContactSupport() throws InterruptedException {
        MobileElement el = (MobileElement) DriverManager.getTlDriver().findElement(contactLink);
        Point center = el.getCenter();
        System.err.println(center);

    }

    public String getInvalidPhoneNumberText(String text) {
        return getTextFromMultipleElements(invalidPhoneNumberText, text);
    }

}
