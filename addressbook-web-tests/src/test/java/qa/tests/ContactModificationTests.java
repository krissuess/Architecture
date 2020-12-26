package qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.model.ContactData;
import qa.model.Contacts;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        if (app.getContactHelper().all().size() == 0) {
            app.getContactHelper().createContactToModifyOrEdit(new ContactData("Var", "Krisss", "Vasilyevsky Island", "12345"));
        };
        Contacts before = app.getContactHelper().all();
        ContactData e = before.iterator().next();
        Comparator<ContactData> compareLastName = Comparator.comparing(ContactData::getLastName);
        Comparator<ContactData> compareName = Comparator.comparing(ContactData::getName);
        app.getContactHelper().initContactModification();

        ContactData a = new ContactData("QQQ", "AAA", "8902333", "");
        app.getContactHelper().fillContactFormForModification(a);
        app.getContactHelper().submitContactModification();
        app.wd.get("http://localhost:8080/addressbook/");

        Contacts after = app.getContactHelper().all();

        Assert.assertEquals(before.size(), after.size());

        Assert.assertEquals(after, before.without(e).withAdded(a));
    }

}
