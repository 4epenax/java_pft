package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/usertile30.jpg");
        list.add(new Object[]{new ContactData().withFirstname("First").withLastname("Last").withAddress("Russia")
                .withEmail("test@mail.tt").withEmail2("test2@mail.tt").withEmail3("test3@mail.tt")
                .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withPhoto(photo).withGroup("test2")});
        list.add(new Object[]{new ContactData().withFirstname("First0").withLastname("Last0").withAddress("Russia0")
                .withEmail("test0@mail.tt").withEmail2("test02@mail.tt").withEmail3("test03@mail.tt")
                .withHomePhone("1110").withMobilePhone("2220").withWorkPhone("3330").withPhoto(photo).withGroup("test2")});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/usertile30.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}