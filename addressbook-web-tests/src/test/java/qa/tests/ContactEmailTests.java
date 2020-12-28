package qa.tests;

import org.testng.annotations.Test;
import qa.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

    @Test
    public void testContactEmails(){
        ContactData contact = app.getContactHelper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);
        assertThat(contact.getAllEmail(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contact){
        return Stream.of(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).
                filter(x->!x.equals("")).collect(Collectors.joining("\n"));
    }
}
