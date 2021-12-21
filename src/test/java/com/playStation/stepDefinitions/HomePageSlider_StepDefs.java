package com.playStation.stepDefinitions;

import com.playStation.pages.HomePage;
import com.playStation.utilities.BrowserUtils;
import com.playStation.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class HomePageSlider_StepDefs {

    HomePage homePage=new HomePage();

    @Then("the user should be able to see {string} button on the {int}")
    public void the_user_should_be_able_to_see_button_on_the_slide(String expectedButtonName,int slideIndex) {
        homePage.smallSlideImage.get(slideIndex).click();
        BrowserUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(homePage.findOutMore.get(slideIndex));
        String actualButtonName=homePage.findOutMore.get(slideIndex).getText();
        assertEquals("Button's name does not match",expectedButtonName,actualButtonName);

    }

    @When("the user click {string} button on the {int}")
    public void the_user_click_button(String buttonName, int slideIndex) {
        BrowserUtils.clickWithJS(homePage.getSlideButton(slideIndex));

    }

    @Then("the user should be able to navigate to {string}")
    public void the_user_should_be_able_to_navigate_to(String expected_Url) {
        String actual_Url= Driver.get().getCurrentUrl();
        assertEquals("Url does not match",expected_Url,actual_Url);
    }

}
