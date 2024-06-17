package pages;

import functions.CustomWaiters;
import functions.WorkWithElements;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waiters = new CustomWaiters(driver);
        workWithElements = new WorkWithElements(driver, waiters);
    }

    protected CustomWaiters waiters;
    protected WorkWithElements workWithElements;
}
