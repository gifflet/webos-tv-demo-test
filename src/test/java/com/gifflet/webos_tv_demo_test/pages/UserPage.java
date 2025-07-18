package com.gifflet.webos_tv_demo_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class UserPage {

    @FindBy(className = "welcome-container")
    private WebElement welcomeDiv;

    public UserPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public boolean isUserInWelcomePage(){
        try{
            return welcomeDiv.isEnabled();
        } catch (Exception e){
            return false;
        }
    }
}
