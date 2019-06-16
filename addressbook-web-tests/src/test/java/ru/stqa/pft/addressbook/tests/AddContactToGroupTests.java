package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

//добавление контакта в группу
public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        if (groups.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test2"));
        }

        if (app.db().contacts().size() == 0) {
            groups = app.db().groups();
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withFirstname("First").withLastname("Last").withAddress("Russia")
                    .withEmail("test@mail.tt").withEmail2("test@mail2.tt").withEmail3("test3@mail.tt")
                    .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").inGroup(groups.iterator().next()));
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
                    .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").inGroup(groups.iterator().next()));
        }
    }

    @Test
    public void testContactAddGroup() {
        Groups allGroups = app.db().groups();
        GroupData addGroup = allGroups.iterator().next();
        int i = 0;
        List<ContactData> contactsListBefore = app.db().contactsList();
        for (ContactData contact : contactsListBefore) {
            if (contact.getGroups().size() == 0) break;
            else if (contact.getGroups().size() > 0) {
                i++;
            }
        }
        ContactData changedContactBefore = contactsListBefore.get(i);
        Groups Before = changedContactBefore.getGroups();
        ContactData contact = new ContactData()
                .withId(changedContactBefore.getId()).inGroup(addGroup);
        app.goTo().homePage();
        app.contact().addToGroup(contact);
        List<ContactData> contactsListAfter = app.db().contactsList();
        ContactData changedContactAfter = contactsListAfter.get(i);
        Groups groupsAfter = changedContactAfter.getGroups();
        assertThat(groupsAfter.size(), equalTo(Before.size() + 1));
        assertThat(groupsAfter, equalTo(Before.withAdded(addGroup)));
        app.goTo().homePage();
    }
}
