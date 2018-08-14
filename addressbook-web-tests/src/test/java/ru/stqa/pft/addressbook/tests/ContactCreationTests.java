package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.initContactCreation();
        app.fillContactForm(new ContactData("testFname", "testLname", "224466", "test@mail.tt"));
        app.submitContactCreation();
        app.gotoHomePage();
    }

}