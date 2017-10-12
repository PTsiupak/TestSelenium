package com.epam.lab.pages;

import com.epam.lab.control.CustomFieldDecorator;
import com.epam.lab.utils.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    private WebDriver driver;

    public PageObject() {
        driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(new CustomFieldDecorator((
                        WebDriverSingleton.getInstance())),
                this);
    }
}