package com.epam.lab.pages;

import com.epam.lab.control.Label;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends PageObject{

    @FindBy(xpath = "//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")
    private Label actionElement;

    public boolean isLoggedIn() {
         return actionElement.isEnabled();
    }
}



