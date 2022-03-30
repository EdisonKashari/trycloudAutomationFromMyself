package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user")
    public WebElement user_name;


    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement login_button;

    @FindBy(xpath = "(//span[normalize-space(text()) = 'Dashboard'])[1]")
    public WebElement dashboard;
}
