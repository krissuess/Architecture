package qa.tests;

import org.testng.annotations.Test;
import qa.model.ContactData;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones(){

        ContactData contact = app.getContactHelper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }



    private String mergePhones(ContactData contact) {
        return Stream.of(contact.getHomePhone(), contact.getMobile(), contact.getWorkPhone()).
                filter(x->!x.equals("")).map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

    }
}
