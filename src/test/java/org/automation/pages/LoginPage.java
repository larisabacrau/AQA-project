package org.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.automation.testdata.User;

public class LoginPage {
    public WebDriver driver;
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);

    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
        enterUsername(email);
        enterPassword(password);
        clickLogin();
    }
    public void login(User standard_user) {
        enterUsername(standard_user.getUsername());
        enterPassword(standard_user.getPassword());
        clickLogin();
    }
    public boolean loginButtonCheck() {
        driver.findElement(loginButton).isDisplayed();
        return true;
    }
}