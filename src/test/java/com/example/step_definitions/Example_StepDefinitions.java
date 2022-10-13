package com.example.step_definitions;

import com.example.pages.ExamplePage;
import com.example.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Example_StepDefinitions {

    ExamplePage googleSearchPage = new ExamplePage();

    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("user types {string} and clicks enter")
    public void user_types_apple_and_clicks_enter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);
    }

    @Then("user sees {string} in the google title")
    public void user_sees_apple_in_the_google_title(String searchKeyword) {
        String expectedTitle = searchKeyword+" - Google'da Ara";
        //String expectedTitleKeyword = "apple";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Titles does not match!!", expectedTitle, actualTitle);
        //Assert.assertTrue(actualTitle.contains(expectedTitleKeyword));
    }
}
