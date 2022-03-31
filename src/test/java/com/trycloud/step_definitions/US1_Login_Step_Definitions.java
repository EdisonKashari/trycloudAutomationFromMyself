package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.HomePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US1_Login_Step_Definitions {
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();

    @Given("user on the login page")
    public void user_on_the_login() {
        String url = ConfigurationReader.getProperty("env");

        Driver.getDriver().get(url);

    }

    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode_userpass123(String name, String password) {

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
        BrowserUtils.waitForVisibility(basePage.dashboard, 10);


        Assert.assertTrue(basePage.dashboard.isDisplayed());


    }

    //US 2
    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String userName, String password) {
        basePage.user_name.sendKeys(userName);
        basePage.password.sendKeys(password);
        basePage.login_button.click();


    }

    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String expectedTitle) {

        String actualTitle = basePage.error_message.getText();

        Assert.assertEquals(expectedTitle, actualTitle);


    }

    //US 3
    @When("the users  log in with valid credentials")
    public void theUsersLogInWithValidCredentials() {
        String userName = ConfigurationReader.getProperty("userName1");
        String password = ConfigurationReader.getProperty("password");

        basePage.user_name.sendKeys(userName);
        basePage.password.sendKeys(password);
        basePage.login_button.click();

    }

    @Then("Verify the user see the following modules:")
    public void verifyTheUserSeeTheFollowingModules(List<String> expectedModules) {

        List<WebElement> allModule = basePage.all_Modules;

        List<String> actualModule = new ArrayList<>();

        for (WebElement elements : allModule) {

            actualModule.add(elements.getAttribute("aria-label"));

        }

        Assert.assertEquals(expectedModules,actualModule);


    }

    //US 4

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        basePage.user_name.sendKeys(ConfigurationReader.getProperty("userName1"));
        basePage.password.sendKeys(ConfigurationReader.getProperty("password"));
        basePage.login_button.click();

    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
       // BrowserUtils.waitForVisibility(basePage.dashboard,10);
       BrowserUtils.sleep(2);
        basePage.clickFileModule(string);

    }
    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);



    }




    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        homePage.checkbox.click();

    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {

      //  BrowserUtils.waitForVisibility(homePage.allcheckbox,10);
        BrowserUtils.sleep(2);

        Assert.assertTrue(homePage.allcheckbox.isDisplayed());

    }


}
