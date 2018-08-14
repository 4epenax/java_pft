package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.initContactCreation();
        app.fillContactForm(new ContactData("testFname", "testLname", "224466", "test@mail.tt"));
        app.submitContactCreation();
        app.gotoHomePage();
    }

}