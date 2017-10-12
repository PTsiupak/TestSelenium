package com.epam.lab.bussinesobjects;

import com.epam.lab.model.Letter;
import com.epam.lab.pages.SendMessagesPage;

public class GmailSendBO {
    private SendMessagesPage sendMessagesPage = new SendMessagesPage();

    public void createNewMail(Letter letter) {
        sendMessagesPage.createLetter(letter);
        sendMessagesPage.getDraft();
    }

    public String getFirstDraftMessageSubject(){
        return sendMessagesPage.getMyDraftMessage();
    }
}
