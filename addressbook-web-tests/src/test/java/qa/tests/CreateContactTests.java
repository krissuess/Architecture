package qa.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import qa.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class CreateContactTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContactToModifyOrEdit(new ContactData("Vass","Kris", "Vasilyevsky Island", "12345"));
        app.wd.get("http://localhost:8080/addressbook/");
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        Comparator<ContactData> compareLastName = Comparator.comparing(ContactData::getLastName);
        Comparator<ContactData> compareName = Comparator.comparing(ContactData::getName);
        before.sort(compareLastName.thenComparing(compareName));
        after.sort(compareLastName.thenComparing(compareName));
        after.remove(0);
        Assert.assertEquals(after, before);
    }
}
