package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    public WebDriver driver;
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    private By thankYouMessage = By.xpath("//h2[@class=\"complete-header\"]");
    private By orderDispatchMessage = By.xpath("//div[@class=\"complete-text\"]");
    private By backHomeButton = By.id("back-to-products");

    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }

    public String getThankYouMessage() {
        return driver.findElement(thankYouMessage).getText();
    }

    public String getOrderDispatchMessage() {
        return driver.findElement(orderDispatchMessage).getText();
    }
    public boolean backHomeButtonIsPresent() {
        try {
            return driver.findElement(backHomeButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
