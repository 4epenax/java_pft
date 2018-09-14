package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("First").withLastname("Last")
                    .withAddress("Russia").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withGroup("test2"));
        }
    }

    @Test
    public void testContactMail() {
        
    }
}
