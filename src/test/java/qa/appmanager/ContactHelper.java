package qa.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import qa.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

//    @BeforeMethod(alwaysRun = true)
//    public void setUp() throws Exception {
//        wd = new ChromeDriver();
//        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        wd.get("http://localhost:8080/addressbook/");
//        login("admin", "secret");
//    }
//
//    public void login(String username, String password) {
//        wd.findElement(By.name("user")).clear();
//        wd.findElement(By.name("user")).sendKeys(username);
//        wd.findElement(By.name("pass")).click();
//        wd.findElement(By.name("pass")).clear();
//        wd.findElement(By.name("pass")).sendKeys(password);
//        wd.findElement(By.xpath("//input[@value='Login']")).click();
//    }
    public void createContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData) {
//        wd.findElement(By.name("firstname")).click();
//        wd.findElement(By.name("firstname")).clear();
//        wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
        type(By.name("firstname") , contactData.getName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
//        wd.findElement(By.name("address")).clear();
//        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());

//        wd.findElement(By.name("mobile")).clear();
//        wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        submitContactCreation();
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() throws Exception {
//        wd.findElement(By.linkText("Logout")).click();
//        wd.quit();
//    }

//    public boolean isElementPresent(By by) {
//        try {
//            wd.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    public boolean isAlertPresent() {
//        try {
//            wd.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
}
