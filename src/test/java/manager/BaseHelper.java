package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseHelper {
    ApplicationManager app = new ApplicationManager();

//    WebDriver driver;
//
//    public BaseHelper(WebDriver driver) {
//        this.driver = driver;
//    }

    private WebElement findElementBase(By by) {
        return app.getDriver().findElement(by);
    }

    private List<WebElement> findElementsBase(By by) {
        return app.getDriver().findElements(by);
    }

    public boolean isElementExist(By by) {
        List<WebElement> list = new ArrayList<>();

        try {
            ApplicationManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            list = findElementsBase(by);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            ApplicationManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        return (list.size() > 0);
    }

    public void clickBase(By by) {
        WebElement element = findElementBase(by);
        element.click();
    }

    public void sendTextBase(By by, String text) {
        WebElement element = findElementBase(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String getTextBase(By by) {
        WebElement element = findElementBase(by);
        return element.getText().trim().toUpperCase();
    }

    public boolean isElementContainsText(String expectedResult, String actualResult) {
        // return actualResult.contains(expectedResult);
        if (actualResult.contains(expectedResult)) {
            return true;
        } else {
            System.out.println("actual result: " + actualResult +
                    " expected result " + expectedResult);
            return false;
        }
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
