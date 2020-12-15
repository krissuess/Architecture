package qa.tests;

import org.testng.annotations.*;
import qa.model.ContactData;

public class CreateContactTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().createContactToModifyOrEdit(new ContactData("Kris", "Vasilyevsky Island", "12345"));
    }


}
