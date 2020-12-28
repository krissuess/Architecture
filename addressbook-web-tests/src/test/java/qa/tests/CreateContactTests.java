package qa.tests;

import org.testng.annotations.*;
import qa.model.ContactData;
import qa.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateContactTests extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.getContactHelper().all();
        ContactData a = new ContactData().withId(3).withLastName("dd").withName("sss").withHomePhone("212121").
                withMobile("2124").withAddress("sasasas").withWorkPhone("1111111");
        app.getContactHelper().createContactToModifyOrEdit(a);
        app.wd.get("http://localhost:8080/addressbook/");
        Contacts after = app.getContactHelper().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(a)));
    }
}
