package com.playStation.stepDefinitions;

import com.playStation.pages.HomePage;
import com.playStation.utilities.BrowserUtils;
import com.playStation.utilities.ConfigurationReader;
import com.playStation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;


public class HomePageComingSoon_StepDefs {

    HomePage homePage=new HomePage();

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        homePage.acceptCookies();
    }

    @When("the user scroll to New releases section")
    public void the_user_scroll_to_NewReleases_section(){

        homePage.scrollDown(0,3200);

    }

    @Then("the user should be able to see right arrow \\(>) to see the Games in Coming soon")
    public void the_user_should_be_able_to_see_to_see_the_Games() {
        BrowserUtils.waitForVisibility(homePage.comingSoonLeftArrowButton,2);
        BrowserUtils.verifyElementDisplayed(homePage.comingSoonLeftArrowButton);
    }

    @Then("the user click the right arrow \\(>) button")
    public void the_user_click_the_right_arrow_button() {

        homePage.getComingSoonRightArrowButton().click();
        BrowserUtils.waitForVisibility(homePage.comingSoonSection,2);
        String actualSection=homePage.comingSoonSection.getText();
        assertEquals("Section does not match","Coming soon",actualSection);
        BrowserUtils.waitFor(1);
        BrowserUtils.takeScreenShot();
    }

    @Then("the last game tile should be {string} in the Coming soon games")
    public void the_last_game_tile_should_be_in_the_Coming_soon_games(String expectedGameName) {

        String actualGameName=homePage.listOfComingSoonGames.get(homePage.listOfComingSoonGames.size()-1).getText();
        assertEquals("Last game tile is not matching",expectedGameName,actualGameName);
    }

}
