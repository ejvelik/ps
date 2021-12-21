package com.playStation.stepDefinitions;

import com.playStation.utilities.BrowserUtils;
import com.playStation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpWindows(){
        Dimension windowsSize = new Dimension(1920, 1080);
        Driver.get().manage().window().setSize(windowsSize);
    }

    @Before
    public void setUpScenario(Scenario scenario){
        BrowserUtils.image = scenario;
    }


    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }

}
