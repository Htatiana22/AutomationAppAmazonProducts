package com.amazon.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver(){
        if(driver ==null){
            driver= createDriver();
        }
        return driver;
    }

    private static AppiumDriver createDriver(){
        DesiredCapabilities capabilities= new DesiredCapabilities();
        ArrayList<String> valuesCapabilities= new ArrayList<>();
        EnvironmentVariables environmentVariables= SystemEnvironmentVariables.createEnvironmentVariables();
        Map<String,String> wikiCapabilities= environmentVariables.asMap();

        for (Map.Entry<String,String> entry: wikiCapabilities.entrySet()
             ) {
            if(entry.getKey().contains("serenity.driver.capabilities")){

                valuesCapabilities.add(entry.getValue());
            }
        }

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,valuesCapabilities.get(0));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,valuesCapabilities.get(1));
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        capabilities.setCapability("appActivity", valuesCapabilities.get(3));
        capabilities.setCapability("appPackage", valuesCapabilities.get(4));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, valuesCapabilities.get(5));
        capabilities.setCapability(MobileCapabilityType.UDID,valuesCapabilities.get(6));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,valuesCapabilities.get(7));

        try{
            return new AndroidDriver( new URL(wikiCapabilities.get("serenity.hub")+"/wd/hub"),capabilities);
        }catch (MalformedURLException e){
            throw new RuntimeException("Appium server URL is invalid ", e);
        }


    }

    public static void quitDriver(){
        if (driver !=null){
            driver.quit();
            driver=null;
        }
    }

}
