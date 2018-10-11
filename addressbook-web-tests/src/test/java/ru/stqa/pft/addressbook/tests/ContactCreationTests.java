package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsCsv() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().withFirstname(split[0]).withLastname(split[1]).withAddress(split[2])
                    .withEmail(split[3]).withEmail2(split[4]).withEmail3(split[5]).withHomePhone(split[6])
                    .withMobilePhone(split[7]).withWorkPhone(split[8])/*.inGroup(split[9])*/.withPhoto(new File(split[10]))});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType()); // List<ContactData>.class
            return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validContactsXml")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        verifyContactListInUI();
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