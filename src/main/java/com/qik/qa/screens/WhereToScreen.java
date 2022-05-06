package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import org.openqa.selenium.By;

public class WhereToScreen extends BasePage {

    /*Variable repository*/
    private static final String SIMILAR_CLASS = "android.widget.TextView";
    private static final String COMMON_PATH = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup";
    private final By whereToInput = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/et_home_search_input']");
    private final By asDefaultPaymentMethodChk = By.xpath("android.widget.CheckBox[@resource-id='com.reeftechnology.reef.mobile:id/cb_default_methods']");
    private final By layOut = By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'com.reeftechnology.reef.mobile:id/frame_map')] ");
    private final By lots = By.xpath("//android.view.View[@content-desc='Google Map']/android.view.View");
    private final By navigateUpBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private final By payNowBtn = By.xpath("//android.widget.Button[@resource-id='com.reeftechnology.reef.mobile:id/btn_pay_now' or contains(text(), 'Now')]");
    private final By continueBtn = By.xpath("//android.widget.Button[@text='Continue']");
    private final By addVehicleLink = By.xpath("android.widget.TextView[@text='Add Vehicle']");
    private final By viewList = By.xpath("//android.widget.FrameLayout[@resource-id='com.reeftechnology.reef.mobile:id/card_view_view_list']");
    private final By beenChargedMsj = By.xpath("//android.widget.TextView[contains(text(), 'You have been charged') or @resource-id='com.reeftechnology.reef.mobile:id/tv_custom_snackbar_message']");
    private final By beenChargeMsjAfterExtendingTime = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_custom_snackbar_message']");
    private final By price = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_pin']");
    private final By hour = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_pick_hour' or contains(text(), 'Hour')]");
    private final By hourOptions = By.xpath("//android.widget.Button[@text='0']");
    private final By okBtn = By.xpath("//android.widget.Button[contains(text(), 'OK') or @resource-id='com.reeftechnology.reef.mobile:id/btn_positive']");
    private final By minutes = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_pick_minutes' or contains(text(), 'Minutes')]");
    private final By minuteOptions = By.xpath("//android.widget.Button[@text='15']");
    private final By streetGeneral = By.xpath("/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/txt_summary_card_title' or contains(text(), 'Street')]");
    private final By streetSpecific = By.xpath("//android.view.ViewGroup/android.widget.TextViewp[contains(text(), 'Street') or @resource-id='com.reeftechnology.reef.mobile:id/txt_summary_card_address']");
    private final By addTimeLink = By.xpath("//" + SIMILAR_CLASS + "[@resource-id='com.reeftechnology.reef.mobile:id/txt_extend']");
    private final By imageExtensionTimeSelectorScreen = By.xpath("//android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout");
    private final By map = By.xpath("//android.view.View[@content-desc='Google Map']");
    private final By fullMap = By.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout[2]");
    private final By lotSelected = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_lot_price' or contains(text(), '$')]");
    private final By getOptionsFromWhereToSearch = By.xpath(COMMON_PATH);
    private final By parkHereBtn = By.xpath("//android.widget.TextView[@text='Park Here' or @resource-id='com.reeftechnology.reef.mobile:id/tv_park_here' or @class='android.widget.TextView']");
    private final By parkingLotOptions = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reeftechnology.reef.mobile:id/recView_location_list']/android.widget.FrameLayout");
    private final By tapHere = By.xpath("//android.widget.TextView[@resource-id='android:id/text1'or contains(text(), 'Tap here')]");
    private final By modalDescriptionLot = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reeftechnology.reef.mobile:id/summary_card']/android.widget.FrameLayout/android.widget.FrameLayout");
    private final By streetDescriptionLot = By.xpath("//android.widget.TextView[@resource-id=\"com.reeftechnology.reef.mobile:id/txt_summary_card_address\"]");
    private final By distanceDescriptionLot = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_summary_card_distance']");
    private final By priceDescriptionLot = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_lot_price']");
    private final By whereToNavegationBar = By.xpath("//android.widget.EditText[@resource-id='com.reeftechnology.reef.mobile:id/input_location_search']");
    private final By locationList = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reeftechnology.reef.mobile:id/recView_location_list']");
    private final By firstLotFromLocationList = By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
    private final By activeParkingSession = By.xpath("//android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup");
    private final By hourTextOnExtendSessionBy = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_pick_hour']");
    private final By minutesTextOnExtendSessionBy = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_pick_minutes']");
    private final By lotNameOnExtendSession = By.xpath("//android.view.ViewGroup//following::android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/txt_title' and contains(@text, 'Lot')]");
    private final By lotNameOnQuoteScreen = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_title']");
    private final By extendSessionBy = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/tv_duration_title']");
    private final By streetLocationImageOnQuoteScreen = By.xpath("//android.widget.RelativeLayout");
    private final By searchFullMapScreen = By.xpath("//android.widget.EditText[@resource-id='com.reeftechnology.reef.mobile:id/edit_search_full_map_screen']");

    /*Actions*/
    public void clickSearchFullMapScreen() {
        doClick(searchFullMapScreen, WaitStrategy.CLICKABLE);
    }

    public boolean isStreetLocationImageOnQuoteScreenDisplayed() {
        return getDisplayedImage(streetLocationImageOnQuoteScreen, WaitStrategy.VISIBLE);
    }

    public String getExtendSessionByText() {
        return getText(extendSessionBy, WaitStrategy.VISIBLE);
    }

    public String getLotNameOnExtendSession() {
        return getText(lotNameOnExtendSession, WaitStrategy.VISIBLE);
    }

    public String getLotNameOnQuoteScreen() {
        return getText(lotNameOnQuoteScreen, WaitStrategy.VISIBLE);
    }

    public String getHourText() {
        return getText(hourTextOnExtendSessionBy, WaitStrategy.VISIBLE);
    }

    public String getMinutesText() {
        return getText(minutesTextOnExtendSessionBy, WaitStrategy.VISIBLE);
    }

    public void getParkingLotOptions() throws InterruptedException {
        for (int i = 0; i < getMultipleElementsText(parkingLotOptions).size(); i++) {
            getMultipleElementsText(parkingLotOptions).get(0)
                    .findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).click();
        }
    }

    public void clickLotFromLocationListLots() {
        doClick(firstLotFromLocationList, WaitStrategy.CLICKABLE);
    }

    public boolean validateLocationListLost(String lots) {

        for (int i = 1; i <= DriverManager.getTlDriver().findElements(By.xpath(COMMON_PATH + i + "/android.widget.TextView[1]")).size(); i++) {
            return DriverManager.getTlDriver().findElements(By.xpath(COMMON_PATH + i + "/android.widget.TextView[1]")).get(i).getText().toLowerCase().startsWith(lots);
        }
        return false;
    }

    public boolean validateLocationListIsEmpty() {
        return (getText(locationList, WaitStrategy.PRESENCE).equalsIgnoreCase(""));

    }

    public boolean validateWhereToNavegationBarIsDisplayed() {
        return getDisplayedImage(whereToNavegationBar, WaitStrategy.VISIBLE);
    }

    public void clickParkHereBtn() {
        doClick(parkHereBtn, WaitStrategy.CLICKABLE);
    }

    public void getOptionsFromWhereToSearchText() throws InterruptedException {

        for (int i = 0; i < getMultipleElementsText(getOptionsFromWhereToSearch).size(); i++) {
            if (getMultipleElementsText(getOptionsFromWhereToSearch).get(i)
                    .findElement(By.className(SIMILAR_CLASS)).getText().contains("Austin")) {

                getMultipleElementsText(getOptionsFromWhereToSearch).get(i)
                        .findElement(By.className(SIMILAR_CLASS)).click();
            }
        }
        getMultipleElementsText(getOptionsFromWhereToSearch);
    }

    public String getSizeMap() {

        return DriverManager.getTlDriver().findElement(map).getAttribute("bounds");
    }

    public boolean validateKeyboardIsBeingShown() {

        return DriverManager.getTlDriver().isKeyboardShown();
    }

    public boolean getFullMapSize() {
        return DriverManager.getTlDriver().findElement(fullMap).getAttribute("bounds").equals(getSizeMap());
    }

    public void clickMap() throws InterruptedException {
        Thread.sleep(5000);
        doClick(map, WaitStrategy.CLICKABLE);
        Thread.sleep(4000);

    }

    public void clickNavigateUpBtn() {

        doClick(navigateUpBtn, WaitStrategy.CLICKABLE);
    }

    public void getLots() throws InterruptedException {
        getMultipleElementsText(lots);
    }

    public void clickLot() throws InterruptedException {
        doClickOptionByContentDesc(lots);
        Thread.sleep(5000);
    }

    public void clickLotSelected() throws InterruptedException {
        Thread.sleep(7000);
        ActionsFactory.tapByElement(lotSelected);
    }

    public void sendTextSearchFullMapScreenInput(String text) {
        doSendKeys(searchFullMapScreen, text, WaitStrategy.PRESENCE);
    }

    public void clickWhereToNavigationBar() {
        doClick(whereToInput, WaitStrategy.CLICKABLE);

    }

    public void zoomMap() throws InterruptedException {
        ActionsFactory.zoomInAndOut(layOut);
    }

    public boolean isContinueBtnDisplayed() {
        return getDisplayedImage(continueBtn, WaitStrategy.VISIBLE);
    }

    public void clickContinueBtn() throws InterruptedException {
        doClick(continueBtn, WaitStrategy.CLICKABLE);

    }

    public void clickAddVehicleLink() {
        doClick(addVehicleLink, WaitStrategy.CLICKABLE);
    }

    public void tapMap() throws InterruptedException {
        Thread.sleep(7000);
        ActionsFactory.doubleTapWithBothFingers();
        ActionsFactory.doubleTapWithBothFingers();

    }


    public void clickViewList() throws InterruptedException {

        doClick(viewList, WaitStrategy.CLICKABLE);
    }

    public void clickPayNowBtn() throws InterruptedException {
        doClick(payNowBtn, WaitStrategy.CLICKABLE);
        Thread.sleep(7000);
    }

    public void clickAsDefaultPaymentMethod() {

        doClick(asDefaultPaymentMethodChk, WaitStrategy.CLICKABLE);
    }

    public String getBeenChargedMsj() {
        return getTextFromMultipleElements(beenChargedMsj,
                "You have been charged $22.35 and your parking session has begun");
    }

    public String getHasBeenExtendedMsj() {
        return getText(beenChargeMsjAfterExtendingTime, WaitStrategy.VISIBLE);
    }

    public String getPrice() {

        return getTextFromMultipleElements(price, "from");
    }

    public String getPriceOnPayNowScreen() {

        return getTextFromMultipleElements(price, "from");
    }

    public String getPriceOnContinueScreen() {

        return getTextFromMultipleElements(price, "from");
    }

    public void clickHour() {
        doClick(hour, WaitStrategy.CLICKABLE);
    }

    public void selectHour() throws InterruptedException {
        doClick(hourOptions, WaitStrategy.CLICKABLE);
    }

    public void clickOkBtn() throws InterruptedException {
        doClick(okBtn, WaitStrategy.CLICKABLE);
    }

    public void clickMinutes() {

        doClick(minutes, WaitStrategy.CLICKABLE);
    }

    public void selectMinutes() throws InterruptedException {
        doClick(minuteOptions, WaitStrategy.CLICKABLE);
    }

    public String getStreetGeneral(String text) {

        return getTextFromMultipleElements(streetGeneral, text);
    }

    public String getStreetSpecific(String text) {

        return getTextFromMultipleElements(streetSpecific, text);
    }

    public void clickAddTimeLink() throws InterruptedException {

        doClick(addTimeLink, WaitStrategy.CLICKABLE);
    }

    public void clickTapHere() throws InterruptedException {
        doClick(tapHere, WaitStrategy.CLICKABLE);
    }

    public boolean getDisplayedModalDescriptionLot() throws InterruptedException {
        return getDisplayedImage(modalDescriptionLot, WaitStrategy.VISIBLE);

    }

    public boolean getDescriptionDetailLot(String street, String distance, String price) throws InterruptedException {
        return (getTextFromMultipleElements(streetDescriptionLot, street).contains(street) &&
                getTextFromMultipleElements(distanceDescriptionLot, distance).contains(distance) &&
                getTextFromMultipleElements(priceDescriptionLot, price).contains(price));
    }

    public boolean isDisplayedImageExtensionTimeSelectorScreen() {
        return getDisplayedImage(imageExtensionTimeSelectorScreen, WaitStrategy.PRESENCE);
    }

    public boolean isDisplayedActiveParkingSession() {
        return getDisplayedImage(activeParkingSession, WaitStrategy.VISIBLE);
    }

}
