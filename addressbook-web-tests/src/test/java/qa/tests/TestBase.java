package qa.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import qa.appmanager.ApplicationManager;

public class TestBase {

    ApplicationManager app = new ApplicationManager(BrowserType.CHROME);


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();

    }

    @AfterMethod(alwaysRun = true)
      public void tearDown() {
        app.stop();
    }

}
