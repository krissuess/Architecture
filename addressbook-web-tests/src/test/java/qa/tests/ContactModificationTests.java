package qa.tests;

import org.testng.annotations.Test;
import qa.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContactToModifyOrEdit(new ContactData("Kris", "Vasilyevsky Island", "12345"));
        };
        app.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        app.wd.get("http://localhost:8080/addressbook/");
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactModification();
        app.getContactHelper().okAfterAlert();
    }

}
