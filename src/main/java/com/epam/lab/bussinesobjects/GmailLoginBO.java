package com.epam.lab.bussinesobjects;

import com.epam.lab.model.User;
import com.epam.lab.pages.GmailHomePage;
import com.epam.lab.pages.GmailLoginPage;

public class GmailLoginBO {
    private GmailHomePage gmailHomePage = new GmailHomePage();
    private GmailLoginPage gmailLoginPage = new GmailLoginPage();

    public void login(User user) {
        gmailLoginPage.typeLoginAndSubmit(user.getLogin());
        gmailLoginPage.typePasswordAndSubmit(user.getPassword());
    }

    public boolean isSignIn() {
        return gmailHomePage.isLoggedIn();
    }
}


