package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

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
        ContactData deletedGroup = before.iterator().next();
        Groups group = deletedGroup.getGroups();
        app.contact().removeFromGroup(deletedGroup);
        Contacts after = app.db().contacts();
        app.goTo().homePage();
    }
}
