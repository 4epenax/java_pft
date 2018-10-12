package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

    @Test
    public void testResetPassword() throws IOException, MessagingException {
        List<UserData> usersList = app.db().usersList();
        String user = String.format(usersList.get(2).getUsername());
        System.out.println(user);
        String email = String.format(usersList.get(2).getEmail());
        String password = "password";
        String newPassword = "TESTpassword";
        app.session().login("administrator", "root");
        app.goTo().managePage();
        app.goTo().manageUsers();
        List<MailMessage> mailMessages = app.james().waitForMail(user, password, 600000);
        String passwordResetLink = findPasswordResetLink(mailMessages, email);
        app.user().resetPasswordFinish(passwordResetLink, newPassword);
        HttpSession session = app.newSession();
        assertTrue(session.login(user, newPassword));
        assertTrue(session.isLoggedInAs(user));
    }

    private String findPasswordResetLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }
}
