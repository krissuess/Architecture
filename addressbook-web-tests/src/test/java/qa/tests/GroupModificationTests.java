package qa.tests;

import org.testng.annotations.Test;
import qa.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void  testGroupModification () {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("n","h","f"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
