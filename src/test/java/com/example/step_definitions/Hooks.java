package com.example.step_definitions;

import com.example.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario) {
        //System.out.println("====Closing browser using cucumber @After");

        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);//takes screenshot
            scenario.attach(screenshot, "image/png", scenario.getName());
        }



        Driver.closeDriver();
    }

}
