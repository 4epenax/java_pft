package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname(),
                    contact.getAddress(), contact.getEmail(), contact.getEmail2(), contact.getEmail3(),
                    contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("First %s", i))
                    .withLastname(String.format("Last %s", i)).withAddress(String.format("Tver %s", i))
                    .withEmail(String.format("test@mail.tt %s", i)).withEmail2(String.format("test2@mail.tt %s", i))
                    .withEmail3(String.format("test3@mail.tt %s", i)).withHomePhone(String.format("111 %s", i))
                    .withMobilePhone(String.format("222 %s", i)).withWorkPhone(String.format("333 %s", i)));
        }
        return contacts;
    }
}