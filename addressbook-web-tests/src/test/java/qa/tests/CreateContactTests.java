package qa.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import qa.model.ContactData;
import qa.model.Contacts;

import java.util.Comparator;
import java.util.List;

public class CreateContactTests extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.getContactHelper().all();
        ContactData a = new ContactData("Vass","Kris", "Vasilyevsky Island", "12345");
        app.getContactHelper().createContactToModifyOrEdit(a);
        app.wd.get("http://localhost:8080/addressbook/");
        Contacts after = app.getContactHelper().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        Assert.assertEquals(after, before.withAdded(a));
    }
}
