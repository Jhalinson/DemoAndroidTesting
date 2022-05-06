package com.qik.qa.factories;

import com.qik.qa.driver.DriverManager;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class ActionsFactory {
    private ActionsFactory() {
        throw new IllegalStateException("Action Factory Class Exception");
    }

    // Tap to an element for 250 milliseconds
    public static void tapByElement(By locator) {
        new TouchAction(DriverManager.getTlDriver())
                .tap(tapOptions().withElement(element(DriverManager.getTlDriver().findElement(locator))))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    // Tap by coordinates
    public static void tapByCoordinates(int x, int y) {
        new TouchAction(DriverManager.getTlDriver()).tap(point(x, y)).waitAction(waitOptions(ofMillis(3000))).perform();
    }

    // Press by element
    public static void pressByElement(AndroidElement element, long seconds) {
        new TouchAction(DriverManager.getTlDriver()).press(element(element)).waitAction(waitOptions(ofSeconds(seconds)))
                .release().perform();
    }

    // Double tap with one finger
    public static void doubleTap() {

        new AndroidTouchAction((PerformsTouchActions) DriverManager.getTlDriver()).press(PointOption.point(360, 710))
                .release().perform().press(PointOption.point(360, 710)).release().perform();

    }

    // Double tap with both finger
    public static void doubleTapWithBothFingers() {
        MultiTouchAction secondTwoFingerPress = new MultiTouchAction(DriverManager.getTlDriver());
        secondTwoFingerPress.add(new TouchAction(DriverManager.getTlDriver())
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(360, 710)).withTapsCount(2)));
        secondTwoFingerPress.add(new TouchAction(DriverManager.getTlDriver())
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(388, 693)).withTapsCount(2)));
        secondTwoFingerPress.perform();

    }

    // Press by coordinates
    public static void pressByCoordinates(int x, int y, long seconds) {
        new TouchAction(DriverManager.getTlDriver()).press(point(x, y)).waitAction(waitOptions(ofSeconds(seconds)))
                .release().perform();
    }

    // Horizontal Swipe by percentages
    public static void horizontalSwipeByPercentage(double startPercentage, double endPercentage,
                                                   double anchorPercentage) {
        Dimension size = DriverManager.getTlDriver().manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        new TouchAction(DriverManager.getTlDriver()).press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(1000))).moveTo(point(endPoint, anchor)).release().perform();
    }

    // Vertical Swipe by percentages
    public static void verticalSwipeByPercentages(double startPercentage, double endPercentage,
                                                  double anchorPercentage) {
        Dimension size = DriverManager.getTlDriver().manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction(DriverManager.getTlDriver()).press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000))).moveTo(point(anchor, endPoint)).release().perform();
    }

    // Swipe by elements
    public static void swipeByElements(AndroidElement startElement, AndroidElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(DriverManager.getTlDriver()).press(point(startX, startY))
                .waitAction(waitOptions(ofMillis(1000))).moveTo(point(endX, endY)).release().perform();
    }

    // Multitouch action by using an android element
    public static void multiTouchByElement(AndroidElement androidElement) {
        TouchAction press = new TouchAction(DriverManager.getTlDriver()).press(element(androidElement))
                .waitAction(waitOptions(ofSeconds(1))).release();

        new MultiTouchAction(DriverManager.getTlDriver()).add(press).perform();
    }

    private static Collection<Sequence> zoomOut(Point locus, int distance) {
        return zoom(locus, 100 + distance, 400, 45, Duration.ofMillis(25));
    }

    private static Collection<Sequence> zoom(Point locus, int startRadius, int endRadius, int pinchAngle,
                                             Duration duration) {
        // convert degree angle into radians. 0/360 is top (12 O'clock).
        double angle = Math.PI / 2 - (2 * Math.PI / 360 * pinchAngle);

        // create the gesture for one finger
        Sequence fingerAPath = zoomSinglefinger("fingerA", locus, startRadius, endRadius, angle, duration);

        // flip the angle around to the other side of the locus and get the gesture for
        // the second finger
        angle = angle + Math.PI;
        Sequence fingerBPath = zoomSinglefinger("fingerB", locus, startRadius, endRadius, angle, duration);

        return Arrays.asList(fingerAPath, fingerBPath);
    }

    private static Sequence zoomSinglefinger(String fingerName, Point locus, int startRadius, int endRadius,
                                             double angle, Duration duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, fingerName);
        Sequence fingerPath = new Sequence(finger, 0);

        double midpointRadius = startRadius + (endRadius > startRadius ? 1 : -1) * 20;

        // find coordinates for starting point of action (converting from polar
        // coordinates to cartesian)
        int fingerStartx = (int) Math.floor(locus.x + startRadius * Math.cos(angle));
        int fingerStarty = (int) Math.floor(locus.y - startRadius * Math.sin(angle));

        // find coordinates for first point that pingers move quickly to
        int fingerMidx = (int) Math.floor(locus.x + (midpointRadius * Math.cos(angle)));
        int fingerMidy = (int) Math.floor(locus.y - (midpointRadius * Math.sin(angle)));

        // find coordinates for ending point of action (converting from polar
        // coordinates to cartesian)
        int fingerEndx = (int) Math.floor(locus.x + endRadius * Math.cos(angle));
        int fingerEndy = (int) Math.floor(locus.y - endRadius * Math.sin(angle));

        // move finger into start position
        fingerPath.addAction(
                finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), fingerStartx, fingerStarty));
        // finger comes down into contact with screen
        fingerPath.addAction(finger.createPointerDown(PointerInput.MouseButton.RIGHT.asArg()));
        // finger moves a small amount very quickly
        fingerPath.addAction(
                finger.createPointerMove(Duration.ofMillis(1), PointerInput.Origin.viewport(), fingerMidx, fingerMidy));
        // pause for a little bit
        fingerPath.addAction(new Pause(finger, Duration.ofMillis(100)));
        // finger moves to end position
        fingerPath
                .addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), fingerEndx, fingerEndy));
        // finger lets up, off the screen
        fingerPath.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        return fingerPath;
    }

    private static Collection<Sequence> zoomIn(Point locus, int distance) {
        return zoom(locus, 200, 200 + distance, 45, Duration.ofMillis(25));
    }

    private static Point getCenter(Rectangle rect) {
        return new Point(rect.x + rect.getWidth() / 2, rect.y + rect.getHeight() / 2);
    }

    public static void zoomInAndOut(By locator) throws InterruptedException {
//		 tap center to dismiss toolbars
        AndroidElement map = DriverManager.getTlDriver().findElement(locator);
        map.click();

        Rectangle mapCoordinates = map.getRect();
        Point center = getCenter(mapCoordinates);

        DriverManager.getTlDriver().perform(zoomOut(center, 1000));
        Thread.sleep(1000);

        DriverManager.getTlDriver().perform(zoomIn(center, 700));
        Thread.sleep(1000);

        DriverManager.getTlDriver().perform(zoomOut(center.moveBy(0, 250), 300));
        Thread.sleep(1000);

        DriverManager.getTlDriver().perform(zoomIn(center.moveBy(0, -100), 300));
        Thread.sleep(3000);
    }

    public static void swipeElementAndroidAndAnyDirection(By locator, String dir) {
        System.err.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        // - Android: 300 ms
        // - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart;
        PointOption pointOptionEnd;

        // init screen variables
        Rectangle rect = DriverManager.getTlDriver().findElement(locator).getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;

        switch (dir) {
            case "DOWN": // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
                break;
            case "UP": // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
                break;
            case "LEFT": // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
                break;
            case "RIGHT": // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(DriverManager.getTlDriver()).press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
                    .perform();
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            e.getCause();
            Thread.currentThread().interrupt();
        }
    }
}
