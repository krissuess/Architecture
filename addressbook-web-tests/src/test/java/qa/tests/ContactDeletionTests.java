package qa.tests;

import org.testng.annotations.Test;
import qa.model.ContactData;
import qa.model.Contacts;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion(){
        if (app.getContactHelper().all().size() == 0) {
            app.getContactHelper().createContactToModifyOrEdit(new ContactData("aaa", "Kris", "Vasilyevsky Island", "12345"));
        };
        app.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        app.wd.get("http://localhost:8080/addressbook/");
        Contacts before = app.getContactHelper().all();
        ContactData a = before.iterator().next();

        app.getContactHelper().chooseContact();
        app.getContactHelper().deleteContact();
        app.wd.switchTo().alert().accept();

        Contacts after = app.getContactHelper().all();
        assertThat(before.size(), equalTo(after.size() + 1));
        assertThat(after, equalTo(before.without(a)));
    }
}
