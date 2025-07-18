package com.gifflet.webos_tv_demo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button")
    private WebElement btnLogin;

    @FindBy(css = ".notification.error")
    private WebElement loginErrorNotification;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void insertEmail(String email){
        emailInput.sendKeys(email);
    }

    public void insertPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        btnLogin.click();
    }

    public boolean isLoginErrorVisible(){
        return loginErrorNotification.isEnabled();
    }
}
