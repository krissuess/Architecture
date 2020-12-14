package qa.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.model.ContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void createContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData) {

        type(By.name("firstname") , contactData.getName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());

        submitContactCreation();
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
        click(By.id("3"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }
}
