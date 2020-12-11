package qa.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import qa.appmanager.ContactHelper;
import qa.model.ContactData;

public class CreateContactTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
      app.getContactHelper().createContact();
      app.getContactHelper().fillContactForm(new ContactData("Kris", "Vasilyevsky Island", "12345"));
    }


}
