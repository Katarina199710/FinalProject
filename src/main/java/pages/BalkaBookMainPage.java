package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Urls;

public class BalkaBookMainPage extends BasePage {
    public BalkaBookMainPage(WebDriver driver) {
        super(driver);
    }

    private final static class Locators {
        private static final By searchField = By.xpath("//input[@type='search']");
        private static final By searchButton = By.xpath("//button[@class='butt1'][1]");
        private static final By resultField = By.id("topic-goods-count");
        private static final By resultFieldNegative = By.xpath("//div[@class='no_goods']");
        private static final By moreButton = By.xpath("//div[@class='more'][1]");
        private static final By option = By.xpath("//a[@data-alt_id='2902']");
        private static final By subOption = By.linkText("Повний перелік");
        private static final By nextButton = By.xpath("//div[@class='swiper-button-next'][1]");
        private static final By ruLanguageButton = By.linkText("RU");
        private static final By uaLanguageButton = By.linkText("UA");
        private static final By qa = By.linkText("Вопросы/ответы");
        private static final By errorMessage = By.xpath("//div[@id='error-layer']");
        private static final By surnameField = By.xpath("//input[@name='secondname']");
        private static final By nameField = By.xpath("//input[@name='firstname']");
        private static final By emailField = By.xpath("//input[@name='email']");
        private static final By passwordField = By.xpath("//input[@name='pass']");
        private static final By password2Field = By.xpath("//input[@name='pass2']");
        private static final By phoneField = By.xpath("//input[@name='phone']");
        private static final By countryField = By.xpath("//span[@class='selectinput maked'][1]");
        private static final By cityField = By.xpath("//input[@name='city']");
        private static final By streetField = By.xpath("//input[@name='street']");
        private static final By houseNumberField = By.xpath("//input[@name='building']");
        private static final By registrationButton = By.xpath("//button[text()='Зареєструватись']");
        private static final By signInButton = By.xpath("//div[@class='client sign-in'][1]");
        private static final By signInWindow = By.xpath("//div[@class='customwnd_content']");
        private static final By kyivCity = By.xpath("//span[text()='Київ']");
        private static final By exitFromCabinet = By.xpath("//div[@class='client-back']");
        private static final By cart = By.xpath("//div[@class='cart how1']");
        private static final By deleteFromCart = By.xpath("//span[@class='del']");
        private static final By makeAnOrder = By.xpath("//a[@class='order butt2']");
        private static final By buy1 = By.xpath("//span[@class='butt3 buy']");
        private static final By plusButt = By.xpath("//span[@class='butt3 plus']");
        private static final By orangeRound1 = By.xpath("//span[text()='1']");
        private static final By orangeRound2 = By.xpath("//span[text()='2']");
        private static final By closeCart = By.xpath("//div[@class='close-butt']");
        private static final By buy2 = By.xpath("//span[text()='Купити']");
        private static final By makeAnOrder2 = By.xpath("//div[@class='order-makeorder-butt']");
        private static final By addToWishList = By.xpath("//span[@data-tooltip='В бажання']");
    }

    public BalkaBookMainPage openMainPage() {
        driver.get(Urls.balkaBookMainPage);
        return this;
    }

    public BalkaBookMainPage openRegisterPage() {
        driver.get(Urls.balkaBookRegisterPage);
        return this;
    }

    public BalkaBookMainPage insertValueToSearchField(String value) {
        workWithElements.sendKeys(Locators.searchField, value);
        workWithElements.click(Locators.searchButton);
        return this;
    }

    public BalkaBookMainPage checkResultOfSearchPositive(String expected) {
        Assert.assertEquals(workWithElements.returnTextFromElement(Locators.resultField), expected);
        return this;
    }

    public BalkaBookMainPage checkResultOfSearchNegative(String expected) {
        Assert.assertEquals(workWithElements.returnTextFromElement(Locators.resultFieldNegative), expected);
        return this;
    }

    public BalkaBookMainPage chooseOptionFromCatalog() {
        workWithElements.click(Locators.moreButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        workWithElements.click(Locators.option);
        return this;
    }

    public BalkaBookMainPage chooseSubOption() {
        workWithElements.click(Locators.subOption);
        return this;
    }

    public BalkaBookMainPage checkTheAdvertisingSlider(int amount) {
        for (int i = 0; i < amount; i++) {
            workWithElements.click(Locators.nextButton);
        }
        return this;
    }

    public BalkaBookMainPage changeLocalizationToRU() {
        workWithElements.click(Locators.ruLanguageButton);
        return this;
    }

    public BalkaBookMainPage checkOFChangeOFLocalization(String expected) {
        Assert.assertEquals(workWithElements.returnTextFromElement(Locators.qa), expected);
        return this;
    }

    public BalkaBookMainPage changeLocalizationToUA() {
        workWithElements.click(Locators.uaLanguageButton);
        return this;
    }

    public BalkaBookMainPage clickSignInButton() {
        workWithElements.click(Locators.signInButton);
        return this;
    }

    public BalkaBookMainPage checkAppearanceOfWindow() {
        WebElement element = driver.findElement(Locators.signInWindow);
        if (element.isDisplayed()) {
            System.out.println("The \"sign in\" window appeared");
        } else {
            System.out.println("The \"sign in\" window is not present");
        }
        return this;
    }

    public BalkaBookMainPage insertSurname(String surname) {
        workWithElements.sendKeys(Locators.surnameField, surname);
        return this;
    }

    public BalkaBookMainPage insertName(String name) {
        workWithElements.sendKeys(Locators.nameField, name);
        return this;
    }

    public BalkaBookMainPage insertEmail(String mail) {
        workWithElements.sendKeys(Locators.emailField, mail);
        return this;
    }

    public BalkaBookMainPage insertPassword(String password) {
        workWithElements.sendKeys(Locators.passwordField, password);
        return this;
    }

    public BalkaBookMainPage insertSecondPassword(String password) {
        workWithElements.sendKeys(Locators.password2Field, password);
        return this;
    }

    public BalkaBookMainPage insertPhoneNumber(String phoneNumber) {
        workWithElements.sendKeys(Locators.phoneField, phoneNumber);
        return this;
    }

    public BalkaBookMainPage selectCity() {
        workWithElements.click(Locators.cityField);
        workWithElements.click(Locators.kyivCity);
        return this;
    }

    public BalkaBookMainPage insertStreet(String nameOfStreet) {
        workWithElements.sendKeys(Locators.streetField, nameOfStreet);
        return this;
    }

    public BalkaBookMainPage insertHouseNumber(String houseNumber) {
        workWithElements.sendKeys(Locators.houseNumberField, houseNumber);
        return this;
    }

    public BalkaBookMainPage clickRegisterButton() {
        workWithElements.click(Locators.registrationButton);
        return this;
    }

    public BalkaBookMainPage checkInvalidField() {
        System.out.println(workWithElements.returnTextFromElement(Locators.errorMessage));
        return this;
    }

    public BalkaBookMainPage checkSuccessfulRegistration() {
        WebElement element = waiters.waitForVisibility(Locators.exitFromCabinet);
        if (element.isDisplayed()) {
            System.out.println("Your registration passed");
        } else {
            System.out.println("Your registration did not passed");
        }
        return this;
    }
    public BalkaBookMainPage exitFromCabinet(){
        workWithElements.click(Locators.exitFromCabinet);
        return this;
    }

    public BalkaBookMainPage addItemToCart() {
        workWithElements.click(Locators.buy1);
        workWithElements.click(Locators.buy2);
        return this;
    }

    public BalkaBookMainPage checkAddingItem() {
        Assert.assertEquals(workWithElements.returnTextFromElement(Locators.orangeRound1), "1");
        return this;
    }

    public BalkaBookMainPage openCart() {
        workWithElements.click(Locators.cart);
        return this;
    }

    public BalkaBookMainPage deleteFromCart() {
        workWithElements.click(Locators.deleteFromCart);
        waiters.switchToAlert().accept();
        return this;
    }

    public BalkaBookMainPage checkDeleteFromCart() {
        WebElement element = waiters.waitForVisibility(Locators.deleteFromCart);
        if (!element.isDisplayed()) {
            System.out.println("Item is deleted");
        } else {
            System.out.println("Item is not deleted");
        }
        return this;
    }

    public BalkaBookMainPage plusItem() {
        workWithElements.click(Locators.plusButt);
        return this;
    }

    public BalkaBookMainPage closeCart() {
        workWithElements.click(Locators.closeCart);
        return this;
    }

    public BalkaBookMainPage checkPlusItem() {
        Assert.assertEquals(workWithElements.returnTextFromElement(Locators.orangeRound2), "2");
        return this;
    }

    public BalkaBookMainPage placeAnOrder() {
        workWithElements.click(Locators.makeAnOrder);
        workWithElements.click(Locators.makeAnOrder2);
        return this;
    }

    public BalkaBookMainPage addToWishList() {
        workWithElements.click(Locators.addToWishList);
        return this;
    }
}
