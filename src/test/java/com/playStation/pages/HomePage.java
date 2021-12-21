package com.playStation.pages;

import com.playStation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#_evidon-accept-button")
    public WebElement acceptCookiesButton;

    @FindBy(css = ".button--next.btn-round__primary.button--balance")
    public WebElement comingSoonRightArrowButton;

    @FindBy(css = "svg[aria-label='Chevron left']")
    public WebElement comingSoonLeftArrowButton;

    @FindBy(xpath = "//*[ contains (text(), 'Coming soon') ]")
    public WebElement comingSoonSection;

    @FindBy(css = "div[class='collection-item is-selected']>div>div>div[class='game-grid__game']")
    public List<WebElement> listOfComingSoonGames;

    @FindBy(css = "div[class='button']>a")
    public List<WebElement> findOutMore;

    @FindBy(css = "div[role='button']")
    public List<WebElement> smallSlideImage;




    public void acceptCookies() {

        try {
            acceptCookiesButton.click();
        }catch (Exception e){

        }

    }

    public void scrollDown(int x, int y) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(" + x + "," + y + ")");

    }

    public WebElement getComingSoonRightArrowButton() {

        return comingSoonRightArrowButton;
    }

    public WebElement getComingSoonSection() {

        return comingSoonSection;
    }

    public  WebElement getSlideButton(int slideIndex) {

        WebElement slideButton = Driver.get().findElement(By.xpath("(//div[@class='button']/a)["+(slideIndex+1)+"]"));

        return slideButton;
    }




}
