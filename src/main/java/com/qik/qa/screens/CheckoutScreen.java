package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class CheckoutScreen extends BasePage {

    /*Variable repository*/
    private static final String SIMILAR_CLASS = "android.widget.RelativeLayout";
    private final By payNowBtn = By.xpath("//android.widget.Button[@resource-id='com.reeftechnology.reef.mobile:id/btn_continue']");
    private final By yesPayNowLink = By.xpath("//android.widget.Button[@text='YES, EXTEND NOW' or @resource-id='android:id/button1']");
    private final By maybeLaterLink = By.xpath("//*[contains(@text, 'Maybe Later')]");
    private final By price = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_pin or contains(text(), 'from')']");
    private final By streetGeneral = By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_title' or contains(text(), 'Street')]");
    private final By streetSpecific = By.xpath("//android.view.ViewGroup/android.widget.TextViewp[contains(text(), 'Street') or @resource-id='com.reeftechnology.reef.mobile:id/tv_address']");
    private final By subtotal = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_sub_total' or contains(text(), '$')]");
    private final By fee = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_fees' or contains(text(), '$')]");
    private final By taxes = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_taxes']");
    private final By total = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_total_cost' or contains(text(), '$')]");
    private final By noPaymentAddedText = By.xpath("//android.widget.TextView[@text='No payment added' or @resource-id='com.reeftechnology.reef.mobile:id/tv_payment_method' or @class='android.widget.TextView']");
    private final By noVehicleAddedText = By.xpath("//android.widget.TextView[@text='No vehicle added' or @resource-id='com.reeftechnology.reef.mobile:id/tv_vehicle' or @class='android.widget.TextView']");
    private final By vehicleOption = By.className(SIMILAR_CLASS);
    private final By vehicleList = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_license_plate']");
    private final By creditCard = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
    private final By paymentMethod = By.className(SIMILAR_CLASS);
    private final By addPaymentMethodLink = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_add_payment_method' or contains(text(),'Add Payment') or @class='android.widget.TextView']");
    private final By addVehicleLink = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_add_vehicle' or contains(text(),'Add Vehicle') or @class='android.widget.TextView']");
    private final By vehicleNotSelectedText = By.xpath("//android.widget.TextView[@text='Select a vehicle to park with' or @resource-id='com.reeftechnology.reef.mobile:id/tv_vehicle' or @class='android.widget.TextView']");
    private final By paymentNotSelectedText = By.xpath("//android.widget.TextView[@text='Select a payment method' or @resource-id='com.reeftechnology.reef.mobile:id/tv_add_payment_method' or @class='android.widget.TextView']");
    private final By lengthStay = By.xpath("//android.widget.RelativeLayout[@resource-id='com.reeftechnology.reef.mobile:id/rl_length_of_stay']");
    private final By vehicleSelected = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_vehicle']");
    private final By buyParkingExtensionBtn = By.xpath("//android.widget.Button[@text='Buy Parking Extension']");
    private final By yesExtendNowBtn = By.xpath("//android.widget.Button[@text='YES, EXTEND NOW']");
    private final By checkoutTitleScreen = By.xpath("//android.widget.TextView[@text='Checkout']");
    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    private final By vehicleName = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_vehicle']");
    private final By paymentMethodLbl = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_payment_method_label']");
    private final By creditCardLbl = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_payment_method']");
    private final By selectPaymentLbl = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_title']");
    private final By lengthStayLbl = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_length_of_stay_label']");
    private final By hourMinutesOnLengthStayLbl = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_length_of_stay']");
    private final By hourOnModalLbl = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_pick_hour']");
    private final By minutesOnModalLbl = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_pick_minutes']");
    private final By touchOutside = By.xpath("//android.view.View[@resource-id='com.reeftechnology.reef.mobile:id/container']");
    private final By totalCost = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_total_cost']");


    /*Actions*/
    public String getTotalCostText() {
        return getText(totalCost, WaitStrategy.VISIBLE);
    }

    public void clickTouchOutside() throws InterruptedException {
        Thread.sleep(3000);
        ActionsFactory.tapByCoordinates(0, 172);
    }
    public boolean isDisplayedOnStayLengthHourMinutesLbl() {
        return getDisplayedImage(hourMinutesOnLengthStayLbl, WaitStrategy.VISIBLE);
    }
    public String getOnLengthStayHourMinutesLbl() {
        return getText(hourMinutesOnLengthStayLbl, WaitStrategy.VISIBLE);
    }
    public boolean isDisplayedOnModalMinutesLbl() {
        return getDisplayedImage(minutesOnModalLbl, WaitStrategy.VISIBLE);
    }
    public String getOnModalMinutesLbl() {
        return getText(minutesOnModalLbl, WaitStrategy.VISIBLE);
    }
    public boolean isDisplayedOnModalHourLbl() {
        return getDisplayedImage(hourOnModalLbl, WaitStrategy.VISIBLE);
    }
    public String getOnModalHourLbl() {
        return getText(hourOnModalLbl, WaitStrategy.VISIBLE);
    }
    public boolean isDisplayedLengthStayLbl() {
        return getDisplayedImage(lengthStayLbl, WaitStrategy.VISIBLE);
    }
    public String getLengthStayLbl() {
        return getText(lengthStayLbl, WaitStrategy.VISIBLE);
    }
    public String getSelectPaymentLbl() {
        return getText(selectPaymentLbl, WaitStrategy.VISIBLE);
    }
    public String getCreditCardLbl() {
        return getText(creditCardLbl, WaitStrategy.VISIBLE);
    }
    public String getPaymentMethodLbl() {
        return getText(paymentMethodLbl, WaitStrategy.VISIBLE);
    }
    public String getVehicleNameText() {
        return getText(vehicleName, WaitStrategy.VISIBLE);
    }
    public void clickBackButton() {
        doClick(backButton, WaitStrategy.VISIBLE);
    }
    public String getCheckoutScreenTitleText() {
        return getText(checkoutTitleScreen, WaitStrategy.VISIBLE);
    }
    public boolean isDisplayedCheckoutScreenTitle() {
        return getDisplayedImage(checkoutTitleScreen, WaitStrategy.VISIBLE);
    }
    public void clickPayNowBtn() throws InterruptedException {
        doClick(payNowBtn, WaitStrategy.CLICKABLE);
    }
    public void clickYesExtendNowBtn() throws InterruptedException {
        Thread.sleep(5000);
        ActionsFactory.tapByElement(yesExtendNowBtn);
    }
    public void clickMaybeLaterLink() throws InterruptedException {
        doClick(maybeLaterLink, WaitStrategy.CLICKABLE);
        Thread.sleep(3000);
    }
    public void clickCorrectVehicleConfirmation() throws InterruptedException {
        doClick(yesPayNowLink, WaitStrategy.CLICKABLE);
    }
    public String getPriceOnCheckoutScreen() {
        return getText(price, WaitStrategy.PRESENCE);
    }
    public String getStreetGeneral(String text) {
        return getTextFromMultipleElements(streetGeneral, text);
    }
    public String getStreetSpecific(String text) {
        return getTextFromMultipleElements(streetSpecific, text);
    }
    public Float getSubtotal() {
        String livePrice = getText(subtotal, WaitStrategy.PRESENCE);
        Float newStr = Float.parseFloat(livePrice.replaceAll("[$,]", ""));
        System.out.println(newStr);
        return newStr;
    }
    public Float getFee() {
        String livePrice = getText(fee, WaitStrategy.PRESENCE);
        Float newStr = Float.parseFloat(livePrice.replaceAll("[$,]", ""));
        System.out.println(newStr);
        return newStr;
    }
    public Float getTaxes() throws InterruptedException {
        Thread.sleep(3000);
        DriverManager.getTlDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().text(\"Taxes\"))"));
        String livePrice = getText(taxes, WaitStrategy.PRESENCE);
        Float newStr = Float.parseFloat(livePrice.replaceAll("[$,]", ""));
        return newStr;
    }
    public Float getTotalCost() {
        String livePrice = getText(total, WaitStrategy.PRESENCE);
        Float newStr = Float.parseFloat(livePrice.replaceAll("[$,]", ""));
        return newStr;
    }
    public String getNoPaymentAddedText() {
        return getTextFromMultipleElements(noPaymentAddedText, "No payment added");
    }
    public String getNoVehicleAddedText() {
        return getTextFromMultipleElements(noVehicleAddedText, "No vehicle added");
    }
    public void clickExtendSessionBtn() throws InterruptedException {
        Thread.sleep(7000);
        ActionsFactory.tapByElement(buyParkingExtensionBtn);
    }
    public void clickVehicle() throws InterruptedException {
        Thread.sleep(10000);
        doClickElementFromList(vehicleOption, 0);
    }
    public void selectVehicle(int vehiclePosition) throws InterruptedException {
        doClickElementFromList(vehicleList, vehiclePosition);
    }
    public void clickPaymentMethod() throws InterruptedException {
        doClickElementFromList(paymentMethod, 1);
    }
    public void selectCreditCard() throws InterruptedException {
        doClickElementFromList(creditCard, 0);
    }
    public void clickAddPaymentMethodLink() {
        doClick(addPaymentMethodLink, WaitStrategy.CLICKABLE);
    }
    public void clickAddVehicleLink() {
        doClick(addVehicleLink, WaitStrategy.CLICKABLE);
    }
    public String getVehicleNotSelectedText() {
        return getTextFromMultipleElements(vehicleNotSelectedText, "Select a vehicle to park with");
    }
    public String getPaymentNotSelectedText() {
        return getTextFromMultipleElements(paymentNotSelectedText, "Select a payment method");
    }
    public void clickLengthStay() {
        doClick(lengthStay, WaitStrategy.CLICKABLE);
    }
    public String getVehicleSelectedName() {
        return getText(vehicleSelected, WaitStrategy.VISIBLE);
    }

}
