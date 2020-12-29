package qa.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.*;
import qa.model.ContactData;
import qa.model.Contacts;
import qa.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateContactTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g)->new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) {
        Contacts before = app.getContactHelper().all();
        File photo = new File("src/test/resources/tree.jpg");
        Assert.assertTrue(photo.exists());
        ContactData a = new ContactData().withId(3).withLastName(contact.getLastName()).
                withName(contact.getName()).withHomePhone(contact.getHomePhone()).
                withMobile(contact.getMobile()).withAddress(contact.getAddress()).
                withWorkPhone(contact.getWorkPhone()).withPhoto(contact.getPhoto());
        app.getContactHelper().createContactToModifyOrEdit(a);
        app.wd.get("http://localhost:8080/addressbook/");
        Contacts after = app.getContactHelper().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(a)));
    }
}
