package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class WalletScreen extends BasePage {

    /*Variable repository*/
    private String SIMILAR_CLASS = "android.view.View";
    private final By addNewPaymentMethod = By.xpath("//android.widget.Button[@text= 'Add New Payment Method']");
    private final By optionsCreditCardDropDown = By.className(SIMILAR_CLASS);
    private final By presentOptions = By.className("android.widget.CheckedTextView");
    private final By addCreditCardFields = By.className("android.widget.EditText");
    private final By optionMonth = By.className(SIMILAR_CLASS);
    private final By monthNumber = By.xpath("//android.widget.ListView/android.widget.CheckedTextView[@resource-id='android:id/text1']");
    private final By optionYear = By.className(SIMILAR_CLASS);
    private final By yearNumber = By.xpath("//android.widget.ListView/android.widget.CheckedTextView[@resource-id='android:id/text1']");
    private final By addCreditCardBtn = By.className("android.widget.Button");
    private final By creditCard = MobileBy.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[@resource-id='com.reeftechnology.reef.mobile:id/iv_credit_card']");
    private final By deleteBtn = By.xpath("//android.widget.FrameLayout/android.widget.ImageView");
    private final By invalidCreditText = MobileBy.xpath("//android.view.View[@text='Invalid credit card number']");
    private final By nameCardLengthTex = MobileBy.xpath("//android.view.View[contains(@text,'Card Holder') and @class='android.view.View']");
    private final By securityCodeText = MobileBy.xpath("//android.view.View[@text='Security Code is required.']");
    private final By monthRequiredText = MobileBy.xpath("//android.view.View[@text= 'The Credit Card Expiration Month is required.']");
    private final By yearRequiredText = MobileBy.className(SIMILAR_CLASS);
    private final By cardNameRequiredText = MobileBy.xpath("//android.view.View[contains(@text,'The Card Holder') and @class='android.view.View' and @package='com.reeftechnology.reef.mobile']");
    private final By cardNumberRequiredText = By.xpath("//android.view.View[contains(@text,'The Credit Card Number') and @class='android.view.View']");

    /*Actions*/
    public String getCardNumberRequiredText() {
        return getTextFromMultipleElements(cardNumberRequiredText, "Credit");
    }

    public String getHolderNameRequiredText() {
        return getTextFromMultipleElements(cardNameRequiredText, "Name");
    }

    public String getYearRequiredText() {
        return getTextFromMultipleElements(yearRequiredText, "Year");
    }

    public String getMonthRequiredText() {
        return getTextFromMultipleElements(monthRequiredText, "Month");
    }

    public String getSecurityCodeText() {
        return getText(securityCodeText, WaitStrategy.PRESENCE);
    }

    public String getNameCardLengthText() {
        return getTextFromMultipleElements(nameCardLengthTex, "Holder");
    }

    public String getInvalidCreditText() {
        return getText(invalidCreditText, WaitStrategy.PRESENCE);
    }

    public void clickAddNewPaymentMethod() {
        doClick(addNewPaymentMethod, WaitStrategy.CLICKABLE);

    }

    public void sendCardNumber(String numberCard) {
        doSendKeysSeveralElements(addCreditCardFields, 0, numberCard);
    }

    public void sendFullNameCard(String nameCard) {
        doSendKeysSeveralElements(addCreditCardFields, 1, nameCard);
    }

    public void sendCvv(String cvv) {
        doSendKeysSeveralElements(addCreditCardFields, 2, cvv);
    }

    public void selectPresentOption(String presentOption) throws InterruptedException {
        doClickElementFromList(optionsCreditCardDropDown, 0);
        doSelectOptionByText(presentOptions, presentOption);
    }

    public void selectMonthOption() throws InterruptedException {
        doClickElementFromList(optionMonth, 0);

    }

    public void clickMonthNumber(String month) throws InterruptedException {
        doSelectOptionByText(monthNumber, month);
    }

    public void selectYearOption() throws InterruptedException {
        doClickElementFromList(optionYear, 1);

    }

    public void clickYearNumber(String year) throws InterruptedException {
        doSelectOptionByText(yearNumber, year);
    }

    public void clickAddCreditCardBtn() throws InterruptedException {
        doClickElementFromList(addCreditCardBtn, 0);

    }

    public void swipeCreditCard(String direction) throws InterruptedException {
        ActionsFactory.swipeElementAndroidAndAnyDirection(creditCard, direction);

    }

    public void clickDeleteBtn() throws InterruptedException {
        doClick(deleteBtn, WaitStrategy.CLICKABLE);
    }

}
