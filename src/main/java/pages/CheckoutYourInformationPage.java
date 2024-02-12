package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    public WebDriver driver;
    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutHeader = By.xpath("//div[@class='header_secondary_container']/descendant::span[@class='title']");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    public void enterFirstName(String firstname) {
        driver.findElement(firstName).sendKeys(firstname);
    }
    public void enterLastName(String lastname) {
        driver.findElement(lastName).sendKeys(lastname);
    }

    public void enterPostalCode(String postcode) {
        driver.findElement(postalCode).sendKeys(postcode);
    }
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void fillInCheckoutInfo(String firstname,String lastname, String postalCode) {
        enterFirstName("Ana");
        enterLastName("Blandiana");
        enterPostalCode("445445");
        clickContinue();


    }

}
