package com.carrefour_online;

import com.carrefour_online.config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactory;

    @BeforeMethod(alwaysRun = true)
    public static void instantiateDriverObject() {
        driverFactory = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory driverFactory = new DriverFactory();
                webDriverThreadPool.add(driverFactory);
                return driverFactory;
            }
        };
    }

    public static WebDriver getDriver() throws Exception {
        return driverFactory.get().getDriver();
    }

    /*

        @AfterMethod(alwaysRun = true)
        public static void clearCookies() throws Exception {
            getDriver().manage().deleteAllCookies();
        }

    */
//    @AfterMethod(alwaysRun = true)
//    public static void closeDriverObjects() {
//        for (DriverFactory driverFactory : webDriverThreadPool) {
//            driverFactory.quitDriver();
//        }
//    }
}
