package com.epam.lab.pages;

import com.epam.lab.control.Button;
import com.epam.lab.control.TextInput;
import com.epam.lab.utils.WebDriverSingleton;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends PageObject {

    public GmailLoginPage(){
        super();
    }

    @FindBy(id = "identifierId")
    private TextInput loginInput;

    @FindBy(name = "password")
    private TextInput passwordInput;

    @FindBy(xpath = "//content[@class='CwaK9']/span[1]")
    private Button nextButton;

    public void typeLoginAndSubmit(String login) {
        loginInput.sendKeys(login);
        nextButton.click();
    }

    public void typePasswordAndSubmit(String password) {
        passwordInput.sendKeys(password);
        WebDriverSingleton.wait("//content[@class='CwaK9']/span[1]");
        nextButton.click();
    }
}



