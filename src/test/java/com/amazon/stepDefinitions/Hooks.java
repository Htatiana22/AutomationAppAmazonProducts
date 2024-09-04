package com.amazon.stepDefinitions;

import com.amazon.utils.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.amazon.db.Connections.logToBD;
import static com.amazon.utils.DriverFactory.quitDriver;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks implements TestWatcher {

    private static final Logger logger= LoggerFactory.getLogger(Hooks.class);

    @Managed
    AppiumDriver driver;

   @Before
   public void setUp(){

        AppiumDriver driver = DriverFactory.getDriver();
        setTheStage(new OnlineCast());
        theActorCalled("User").can(
                BrowseTheWeb.with(driver)
        );
   }
    @After
    public void tearDown(Scenario scenario){

        String status= scenario.isFailed() ? "FAILED" : "PASSED";
        logger.info("Scenario '{}' {}.", scenario.getName(), status);

        String message="Scenario '"+ scenario.getName() +"' "+ status;
        logToBD(
                status.equals("FAILED")? "ERROR":"INFO",
                logger,
                message,
                Thread.currentThread().getName()
        );

        quitDriver();
    }
}
