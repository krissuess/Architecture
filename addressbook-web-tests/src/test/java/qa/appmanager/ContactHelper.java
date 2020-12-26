package qa.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.model.ContactData;
import qa.model.Contacts;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void createContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("firstname") , contactData.getName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        submitContactCreation();
    }

    public void  fillContactFormForModification(ContactData contactData){
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("firstname") , contactData.getName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element: elements){
            String lastName = element.findElements(By.tagName("td")).get(1).getText();
            String name = element.findElements(By.tagName("td")).get(2).getText();
            ContactData contactData = new ContactData(lastName ,name, "", "");
            contacts.add(contactData);
        }
        return contacts;
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void initContactModification() {
        click(By.cssSelector("img[alt=\"Edit\"]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void okAfterAlert() {
        click(By.linkText("home page"));
    }

    public void chooseContact() {
        click(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void createContactToModifyOrEdit(ContactData contact) {
        createContact();
        fillContactForm(contact);
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
}
