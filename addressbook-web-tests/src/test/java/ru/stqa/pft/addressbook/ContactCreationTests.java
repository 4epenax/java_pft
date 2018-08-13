package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new ContactData("testFname", "testLname", "224466", "test@mail.tt"));
        submitContactCreation();
        gotoHomePage();
    }

}