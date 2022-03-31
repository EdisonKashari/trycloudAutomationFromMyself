package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public  class BasePage {

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

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement error_message;

    @FindBy(xpath = "//ul[@id='appmenu']//li[@data-id]/a")
    public List<WebElement> all_Modules;



    public void clickFileModule(String file){
      String locator = " (//a[@aria-label='"+file+"'])[1]";

      WebElement element = Driver.getDriver().findElement(By.xpath(locator));
      element.click();
    }
}
