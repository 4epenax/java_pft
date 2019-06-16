package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

//тест форм ввода данных
public class ContactAddressTests extends TestBase {

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
    public void testContactAddress() {
        app.goTo().homePage();
        ContactData contact = app.db().contacts().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAddress(), equalTo((contactInfoFromEditForm.getAddress())));
        verifyContactListInUI();
    }
}
