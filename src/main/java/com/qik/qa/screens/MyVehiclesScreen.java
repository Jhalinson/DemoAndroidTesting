package com.qik.qa.screens;

import com.qik.qa.basepage.BasePage;
import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ActionsFactory;
import org.openqa.selenium.By;

public class MyVehiclesScreen extends BasePage {

    /*Variable repository*/
    private final By addVehicleBtn = By.id("com.reeftechnology.reef.mobile:id/btn_add_new_vehicle");
    private final By nickNameTxt = By.id("com.reeftechnology.reef.mobile:id/edit_car_nickname");
    private final By licenseTxt = By.id("com.reeftechnology.reef.mobile:id/edit_licence_plate_number");
    private final By licenseCountry = By.xpath("//android.widget.Spinner[@resource-id='com.reeftechnology.reef.mobile:id/spinner_country_picker']");
    private final By selectCountryOptions = By.className("android.widget.TextView");
    private final By licenseState = By.xpath("//android.widget.Spinner[@resource-id='com.reeftechnology.reef.mobile:id/spinner_licence_plate_state']");
    private final By selectStatesOptions = By.className("android.widget.TextView");
    private final By setDefault = By.xpath("//android.widget.CheckBox[@text='Set as Default']");
    private final By saveBtn = By.xpath("//android.widget.Button[@text='SAVE']");
    private final By vehicle = By.xpath("//android.widget.TextView[@resource-id='com.reeftechnology.reef.mobile:id/license' and @class='android.widget.TextView' and @focusable='false']");
    private final By optionsBtn = By.className("android.widget.ImageView");
    private final By optionConfirmDeletingVehicle = By.className("android.widget.Button");
    private final By cancelSaveBtn = By.className("android.widget.Button");
    private final By editVehicleTxt = By.className("android.widget.EditText");
    private final By cannotDeleteLastVehicleText = By.xpath("//android.widget.TextView[@text='Cannot delete last vehicle' or @resource-id='com.reeftechnology.reef.mobile:id/snackbar_text']");
    private final By vehicleOptions = By.xpath("//android.view.ViewGroup[@resource-id='com.reeftechnology.reef.mobile:id/content' and @class='android.view.ViewGroup']/android.widget.TextView");
    private  final By vehicleTitleScreen = By.xpath("//*[contains(@text,'Select Vehicle')]");

    /*Actions*/
    public String getMyVehiclesTitleScreenText()  {
        return getText(vehicleTitleScreen, WaitStrategy.VISIBLE);
    }

    public boolean isDisplayedMyVehiclesTitleScreen()  {
        return getDisplayedImage(vehicleTitleScreen, WaitStrategy.VISIBLE);
    }
    public void getVehicleOptionsAndselectOneAsDefault() throws InterruptedException {
        for (int i = 0; i < getMultipleElementsText(vehicleOptions).size(); i++) {

            if (getMultipleElementsText(vehicleOptions).get(i).getText().equalsIgnoreCase("Set as default")) {

                getMultipleElementsText(vehicleOptions).get(i).click();
                break;
            }
        }

    }

    public String getVehicleSelectedAsDefault() throws InterruptedException {
        String vehicleStatus = "";
        for (int j = 0; j < getMultipleElementsText(vehicleOptions).size(); j++) {
            if (getMultipleElementsText(vehicleOptions).get(j).getText().equalsIgnoreCase("Default")) {

                vehicleStatus = getMultipleElementsText(vehicleOptions).get(j).getText();
                System.out.println("Vehicle selected as default::: " + vehicleStatus);
                break;
            }

        }

        return vehicleStatus;
    }

    public String getCannotDeleteLastVehicleText() {
        return getTextFromMultipleElements(cannotDeleteLastVehicleText, "Cannot delete last vehicle");
    }

    public void clickAddVehicle() {

        doClick(addVehicleBtn, WaitStrategy.CLICKABLE);
    }

    public void sendNickNameText(String nickname) {
        doSendKeys(nickNameTxt, nickname, WaitStrategy.PRESENCE);

    }
    public void sendLicenseText(String licenseText) {

        doSendKeys(licenseTxt, licenseText, WaitStrategy.PRESENCE);
        DriverManager.getTlDriver().executeScript("mobile:keyevent", "keycode:66");
    }

    public void selectCountry(String selectCountry) throws InterruptedException {
        doClick(licenseCountry, WaitStrategy.CLICKABLE);
        doSelectOptionByText(selectCountryOptions, selectCountry);
    }

    public void selectState(String selectState) throws InterruptedException {
        doClick(licenseState, WaitStrategy.CLICKABLE);
        doSelectOptionByText(selectStatesOptions, selectState);
    }

    public void clickSetAsDefault() {
        doClick(setDefault, WaitStrategy.CLICKABLE);
    }

    public void clickSaveBtn() {
        doClick(saveBtn, WaitStrategy.CLICKABLE);
    }

    public void swipeVehicle(String direction) throws InterruptedException {
        Thread.sleep(7000);
        ActionsFactory.swipeElementAndroidAndAnyDirection(vehicle, direction);
    }

    public void clickDeleteOrEditBtn(int position) throws InterruptedException {

        doClickElementFromList(optionsBtn, position);
    }

    public void clickCancelOrSaveBtn(int position) throws InterruptedException {

        doClickElementFromList(cancelSaveBtn, position);
    }

    public void clickYesDeleteBtn(int position) throws InterruptedException {

        doClickElementFromList(optionConfirmDeletingVehicle, position);
    }

    public void fillEditVehicleNickNameTxt(String text) {
        doSendKeys(editVehicleTxt, text, WaitStrategy.PRESENCE);
    }

}
