package com.epam.lab.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        WebDriver instance;
        // For Ubuntu
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // For Windows
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        instance = new ChromeDriver();
        instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        instance.get(new EnvProperties().getBaseUrl());
        webDriverThreadLocal.set(instance);
        return webDriverThreadLocal.get();
    }

    public static void wait(String locator) {
        new WebDriverWait(WebDriverSingleton.getInstance(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void quit() {
        try {
            webDriverThreadLocal.get().quit();
        } finally {
            webDriverThreadLocal.remove();
        }
    }
}

