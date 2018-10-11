package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }

        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withFirstname("First").withLastname("Last").withAddress("Russia")
                    .withEmail("test@mail.tt").withEmail2("test@mail2.tt").withEmail3("test3@mail.tt")
                    .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").inGroup(groups.iterator().next()));
        }

    }

    @Test
    public void testRemoveContactFromGroup() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        ContactData selectedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(selectedContact.getId()).withFirstname(selectedContact.getFirstname())
                .withLastname(selectedContact.getLastname()).withAddress(selectedContact.getAddress())
                .withMobilePhone(selectedContact.getMobilePhone()).withHomePhone(selectedContact.getHomePhone())
                .withWorkPhone(selectedContact.getWorkPhone()).withEmail(selectedContact.getEmail())
                .withEmail2(selectedContact.getEmail2()).withEmail3(selectedContact.getEmail3());
        app.contact().removeFromGroup(contact, groups);
        app.goTo().homePage();
        app.contact().allContacts();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(selectedContact).withAdded(contact)));
    }
}
