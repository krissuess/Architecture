package qa.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactModification();
        app.getContactHelper().okAfterAlert();
    }

}
