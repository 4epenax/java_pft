package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstname("First").withLastname("Last").withGroup("test2"));
        }
    }

    @Test
    public void testContactDeletion() {
        Set<ContactData> before = app.contact().all();
        ContactData deletionContact = before.iterator().next();
        app.contact().delete(deletionContact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletionContact);
        Assert.assertEquals(before, after);
    }
}
