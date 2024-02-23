package org.automation.pages;

import org.automation.utils.RandomGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    public WebDriver driver;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");

    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstname) {
        driver.findElement(firstName).sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        driver.findElement(lastName).sendKeys(lastname);
    }

    public void enterPostalCode(int postcode) {
        driver.findElement(postalCode).sendKeys(String.valueOf(postcode));
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

    public void fillInCheckoutInfo() {
        enterFirstName(RandomGenerator.stringValue(10));
        enterLastName(RandomGenerator.stringValue(8));
        enterPostalCode(RandomGenerator.integerValue(6));
        clickContinue();
    }

}
