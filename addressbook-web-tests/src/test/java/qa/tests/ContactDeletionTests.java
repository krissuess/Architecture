package qa.tests;

import org.testng.annotations.Test;
import qa.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContactToModifyOrEdit(new ContactData("Kris", "Vasilyevsky Island", "12345"));
        };
        app.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        app.wd.get("http://localhost:8080/addressbook/");
        app.getContactHelper().chooseContact();
        app.getContactHelper().deleteContact();
        app.wd.switchTo().alert().accept();

    }
}
