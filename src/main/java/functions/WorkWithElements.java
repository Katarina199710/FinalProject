package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkWithElements {
    private WebDriver driver;
    private CustomWaiters waiters;

    public WorkWithElements(WebDriver driver, CustomWaiters waiters) {
        this.driver = driver;
        this.waiters = waiters;
    }

    public void click(By locator){
        waiters.waitForVisibility(locator);
        driver.findElement(locator).click();
    }

    public String returnTextFromElement(By locator){
        waiters.waitForVisibility(locator);
        return driver.findElement(locator).getText();
    }
    public void sendKeys(By locator, String value){
        waiters.waitForVisibility(locator).sendKeys(value);
    }
}
