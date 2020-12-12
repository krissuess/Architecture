package qa.tests;


import org.testng.annotations.*;
import qa.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("n",null,null));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();


    }

}


