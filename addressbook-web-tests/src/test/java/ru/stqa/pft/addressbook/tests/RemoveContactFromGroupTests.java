package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

//удаление сонтакта из группы
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

        int i = 0;
        List<ContactData> contactsList = app.db().contactsList();
        for (ContactData contact : contactsList) {
            if (contact.getGroups().size() > 0 ) break;
            else {
                i ++;
            }
        }
        if (i == contactsList.size()) {
            Groups allGroups = app.db().groups();
            GroupData addedGroup = allGroups.iterator().next();
            ContactData modifiedContactBefore = contactsList.get(0);
            ContactData contact = new ContactData()
                    .withId(modifiedContactBefore.getId()).inGroup(addedGroup);
            app.goTo().homePage();
            app.contact().addToGroup(contact);
        }
    }

    @Test
    public void testContactRemoveGroup() {
        int i = 0;
        List<ContactData> contactsList = app.db().contactsList();
        for (ContactData contact : contactsList) {
            if (contact.getGroups().size() > 0 ) break;
            else {
                i ++;
            }
        }
        app.goTo().homePage();
        ContactData changedContactBefore = contactsList.get(i);
        Groups groupsBefore = changedContactBefore.getGroups();
        GroupData groupToDelete = groupsBefore.iterator().next();
        app.contact().removeFromGroup(changedContactBefore);
        List<ContactData> contactsListAfter = app.db().contactsList();
        ContactData changedContactAfter = contactsListAfter.get(i);
        Groups groupsAfter  = changedContactAfter.getGroups();
        assertThat(groupsAfter.size(), equalTo(groupsBefore.size() - 1));
        assertThat(groupsAfter, equalTo(groupsBefore.without(groupToDelete)));
        app.goTo().homePage();
    }
}
