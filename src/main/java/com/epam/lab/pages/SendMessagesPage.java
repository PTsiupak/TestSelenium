package com.epam.lab.pages;

import com.epam.lab.control.Button;
import com.epam.lab.control.Label;
import com.epam.lab.control.TextInput;
import com.epam.lab.model.Letter;
import org.openqa.selenium.support.FindBy;

public class SendMessagesPage extends PageObject {

    @FindBy(name = "to")
    private TextInput toInput;

    @FindBy(name = "subjectbox")
    private TextInput subjectInput;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private TextInput textMessageInput;

    @FindBy(className = "Ha")
    private Button saveAndClose;

    @FindBy(xpath = "//div[contains(@jscontroller,'DUNnfe')]//div[contains(@role,'navigation')]//a[contains (@href,'#drafts')]")
    private Button goToDraft;

    @FindBy(xpath = "//*[@id=\":2\"]/div/div[2]/div[3]/div[1]//tbody/tr")
    private Button draftMess;

    @FindBy(className = "z0")
    private Button composeButton;

    @FindBy(xpath = "//*[@id=\":2\"]/div/div[2]/div[3]/div[1]//tbody/tr/td[6]//span")
    private Label myDraftMessage;

    public void createLetter(Letter letter) {
        composeButton.click();
        toInput.sendKeys(letter.getTo());
        toInput.click();
        subjectInput.sendKeys(letter.getSubject());
        textMessageInput.sendKeys(letter.getContent());
        saveAndClose.click();
    }

    public void getDraft() {
        goToDraft.click();
        draftMess.click();
    }
    public String getMyDraftMessage() {
        return myDraftMessage.getText();
    }
}
