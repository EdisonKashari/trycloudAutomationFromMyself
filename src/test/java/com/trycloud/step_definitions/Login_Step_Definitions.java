package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.lang.module.Configuration;

public class Login_Step_Definitions {
    BasePage basePage = new BasePage();

    @Given("user on the login page")
    public void user_on_the_login() {
        String url = ConfigurationReader.getProperty("env");

        Driver.getDriver().get(url);

    }
    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode_userpass123(String name,String password) {

        basePage.user_name.sendKeys(name);
        basePage.password.sendKeys(password);


    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        basePage.login_button.click();

    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {

        BrowserUtils.hover(basePage.dashboard);
        BrowserUtils.waitForVisibility(basePage.dashboard,10);




        Assert.assertTrue(basePage.dashboard.isDisplayed());
       // BrowserUtils.sleep(3);

     //   System.out.println("basePage.dashboard.getText() = " + basePage.dashboard.getText());

    }

}
