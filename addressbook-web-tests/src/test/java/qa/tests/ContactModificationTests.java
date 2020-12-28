package qa.tests;

import org.testng.annotations.Test;
import qa.model.ContactData;
import qa.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        if (app.getContactHelper().all().size() == 0) {
            app.getContactHelper().createContactToModifyOrEdit(new ContactData("Var", "Krisss", "Vasilyevsky Island", "12345"));
        }
        Contacts before = app.getContactHelper().all();
        ContactData e = before.iterator().next();
        app.getContactHelper().initContactModification();

        ContactData a = new ContactData("QQQ", "AAA", "8902333", "");
        app.getContactHelper().fillContactFormForModification(a);
        app.getContactHelper().submitContactModification();
        app.wd.get("http://localhost:8080/addressbook/");

        Contacts after = app.getContactHelper().all();
        assertThat(before.size(), equalTo(after.size()));
        assertThat(after, equalTo(before.without(e).withAdded(a)));
    }
}
