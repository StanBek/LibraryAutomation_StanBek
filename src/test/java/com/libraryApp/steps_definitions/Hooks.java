package com.libraryApp.steps_definitions;

import com.libraryApp.testbase.PagesInitializer;
import com.libraryApp.utils.BrowserUtils;
import com.libraryApp.utils.ConfigurationReader;
import com.libraryApp.utils.DBUtils;
import com.libraryApp.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.sql.Connection;
import java.sql.SQLException;

public class Hooks {

  @Before
    public void setupPage() {
    DBUtils.createConnection();
    //PagesInitializer.initializePageObjects();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] screenshot;
            screenshot = BrowserUtils.takeScreenshot("failed/" + scenario.getName());
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DBUtils.closeConnection();
       Driver.close();
    }
}
