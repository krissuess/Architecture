package qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.model.ContactData;
import qa.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContactToModifyOrEdit(new ContactData("Kris", "Vasilyevsky Island", "12345"));
        };
        List<ContactData> before = app.getContactHelper().getContactList();

        Comparator<ContactData> compareLastName = Comparator.comparing(ContactData::getLastName);
        Comparator<ContactData> compareName = Comparator.comparing(ContactData::getName);
        app.getContactHelper().initContactModification();

        ContactData a = new ContactData("QQQ", "AAA", "8902333", "");
        app.getContactHelper().fillContactFormForModification(a);
        app.getContactHelper().submitContactModification();
        app.wd.get("http://localhost:8080/addressbook/");

        List<ContactData> after = app.getContactHelper().getContactList();
        after.sort(compareLastName.thenComparing(compareName));
        Assert.assertEquals(before.size(), after.size());
        before.remove(0);
        before.add(a);
        before.sort(compareLastName.thenComparing(compareLastName));

        Assert.assertEquals(before, after);
    }

}
