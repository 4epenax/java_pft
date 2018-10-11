package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test2"));
        }

        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withFirstname("First").withLastname("Last").withAddress("Russia")
                    .withEmail("test@mail.tt").withEmail2("test@mail2.tt").withEmail3("test3@mail.tt")
                    .withHomePhone("111").withMobilePhone("222").withWorkPhone("333"));
        }

        int i = 0;
        Contacts contactsList = app.db().contacts();
        for (ContactData contact : contactsList) {
            if (contact.getGroups().size() == 0) {
                i++;
            }
        }

        if (i == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("First").withLastname("Last").withAddress("Russia")
                    .withEmail("test@mail.tt").withEmail2("test@mail2.tt").withEmail3("test3@mail.tt")
                    .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").inGroup(group));
        }
    }

    @Test
    public void testAddContactToGroup() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        ContactData selectedContact = before.iterator().next();
        GroupData group = groups.iterator().next();
        ContactData contact = new ContactData()
                .withId(selectedContact.getId()).withFirstname(selectedContact.getFirstname())
                .withLastname(selectedContact.getLastname()).withAddress(selectedContact.getAddress())
                .withMobilePhone(selectedContact.getMobilePhone()).withHomePhone(selectedContact.getHomePhone())
                .withWorkPhone(selectedContact.getWorkPhone()).withEmail(selectedContact.getEmail())
                .withEmail2(selectedContact.getEmail2()).withEmail3(selectedContact.getEmail3())
                .inGroup(group);
        app.contact().addToGroup(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(selectedContact).withAdded(contact)));
    }
}
