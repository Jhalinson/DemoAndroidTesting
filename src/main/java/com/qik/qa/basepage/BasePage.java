package com.qik.qa.basepage;

import com.qik.qa.driver.DriverManager;
import com.qik.qa.enums.ScrollStrategy;
import com.qik.qa.enums.WaitStrategy;
import com.qik.qa.factories.ExplicitWaitFactory;
import com.qik.qa.factories.ScrollFactory;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage {

    Random random;
    List<String> returnsLost;

    protected String getTitle() {
        return DriverManager.getTlDriver().getTitle();
    }

    protected void doClick(By locator, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).click();

    }

    protected void doSendKeys(By locator, String text, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).sendKeys(text);

    }

    protected void doClearField(By locator, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).clear();

    }

    protected boolean getDisplayedImage(By locator, WaitStrategy waitStrategy) {
        AndroidElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        return element.isDisplayed();

    }
    protected Dimension getSizeImage(WaitStrategy waitStrategy, By locator){
        AndroidElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        return element.getSize();

    }

    protected boolean getStateSwitch(By locator) {
        return DriverManager.getTlDriver().findElement(locator).getAttribute("checked").equals("true");

    }


    protected String getText(By locator, WaitStrategy waitStrategy) {
        return ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).getText();

    }

    protected void doScroll(ScrollStrategy scrollStrategy, String resourceId, String text) {

        ScrollFactory.performScroll(scrollStrategy, resourceId, text);
    }

    protected List<AndroidElement> doSendKeysSeveralElements(By locator, int i, String text) {

        List<AndroidElement> textFields = DriverManager.getTlDriver().findElements(locator);
        textFields.get(i).sendKeys(text);
        return textFields;

    }

    protected List<AndroidElement> getMultipleElementsText(By locator) throws InterruptedException {

        return DriverManager.getTlDriver().findElements(locator);

    }

    protected String getTextFromMultipleElements(By locator, String text) {

        List<AndroidElement> elements = DriverManager.getTlDriver().findElements(locator);
        String lines = "";
        for (int i = 0; i < elements.size(); i++) {
            lines = elements.get(i).getText();
            if (lines.contains(text)) {

                break;
            }
        }

        return lines;

    }

    protected void doClickElementFromList(By locator, int index) throws InterruptedException {

        for (int i = 0; i < getMultipleElementsText(locator).size(); ) {

            getMultipleElementsText(locator).get(index).click();
        }

    }

    protected void doSelectOptionByText(By locator, String optionText) throws InterruptedException {

        for (int i = 0; i < getMultipleElementsText(locator).size(); i++) {

            if (getMultipleElementsText(locator).get(i).getText().equalsIgnoreCase(optionText)) {
                getMultipleElementsText(locator).get(i).click();
                break;
            }

        }
    }

    protected String doGetOptionByContentDesc(By locator) throws InterruptedException {

        returnsLost = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < getMultipleElementsText(locator).size(); i++) {

            String lots = getMultipleElementsText(locator).get(i).getAttribute("content-desc");
            returnsLost.add(lots);

        }
        return returnsLost.get(random.nextInt(returnsLost.size()));

    }

    protected void doClickOptionByContentDesc(By locator) throws InterruptedException {

        String d = doGetOptionByContentDesc(locator);
        for (int i = 0; i < getMultipleElementsText(locator).size(); i++) {

            if (getMultipleElementsText(locator).get(i).getAttribute("content-desc").equalsIgnoreCase(d)) {
                getMultipleElementsText(locator).get(i).click();

            }

        }

    }

    protected Actions doActionsMoveToElement(By locator) {
        Actions act = new Actions(DriverManager.getTlDriver());
        act.moveToElement(DriverManager.getTlDriver().findElement(locator)).build().perform();
        return act;
    }

    protected Actions doMoveAndClick(By locator) {
        Actions act = new Actions(DriverManager.getTlDriver());
        act.moveToElement(DriverManager.getTlDriver().findElement(locator)).click().build().perform();
        return act;
    }

}
