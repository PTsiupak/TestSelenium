package com.epam.lab;

import com.epam.lab.bussinesobjects.GmailLoginBO;
import com.epam.lab.bussinesobjects.GmailSendBO;
import com.epam.lab.model.Letter;
import com.epam.lab.model.User;
import com.epam.lab.utils.DataUtils;
import org.testng.*;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static com.epam.lab.utils.WebDriverSingleton.quit;

@Listeners(TestNGListener.class)
public class GmailTest {

//    @DataProvider(name = "data", parallel = true)
//    public static Object[][] credentials() {
//        //for Ubuntu
////      List<User> users = DataUtils.getListUsersFromXML(new File("/home/pvl/IdeaProjects/TestSelenium/src/test/resources/users.xml"));
////      List<Letter> letters = DataUtils.getListLettersFromXML(new File("/home/pvl/IdeaProjects/TestSelenium/src/test/resources/letters.xml"));
//        List<User> users = DataUtils.getListUsersFromXML(new File("src\\test\\resources\\users.xml"));
//        List<Letter> letters = DataUtils.getListLettersFromXML(new File("src\\test\\resources\\letters.xml"));
//        Object[][] objects = new Object[users.size()][2];
//        for (int i = 0; i < users.size(); i++) {
//                objects[i][0] = users.get(i);
//                objects[i][1] = letters.get(i);
//            }
//        return objects;
//    }

        @DataProvider(name = "data", parallel = true)
        public static Object[][] credentials() {
            List<User> users = null;
            List<Letter> letters = null;
            try {
                users = DataUtils.getListUsersFromCSV(new File("src\\test\\resources\\users.csv"));
                //letters = DataUtils.getListLettersFromCSV(new File("src\\test\\resources\\letters.csv"));
                letters = DataUtils.getListLettersFromExcel(new File("src\\test\\resources\\letters.xlsx"));

            } catch (IOException e) {
                e.printStackTrace();
            }

        Object[][] objects = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
                objects[i][0] = users.get(i);
                objects[i][1] = letters.get(i);
            }
        return objects;
    }

    @Test(dataProvider = "data")
    public void testGmail(User user, Letter letter) {
        GmailLoginBO gmailLoginBO = new GmailLoginBO();
        GmailSendBO gmailSendBO = new GmailSendBO();
        gmailLoginBO.login(user);
        Assert.assertTrue(gmailLoginBO.isSignIn());
        gmailSendBO.createNewMail(letter);
        Assert.assertTrue(gmailSendBO.getFirstDraftMessageSubject().equals(letter.getSubject()));
    }


    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        quit();
    }
}
