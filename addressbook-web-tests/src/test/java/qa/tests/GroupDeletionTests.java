package qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.model.GroupData;
import qa.model.Groups;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1").withHeader("").withFooter(""));
        }
    }

  @Test
  public void testGroupDeletion() {
      Groups before = app.group().all();
      GroupData deletedGroup = before.iterator().next();
      app.group().delete(deletedGroup);
      Groups after = app.group().all();
      Assert.assertEquals(after.size(), before.size() -1);
      Assert.assertEquals(after, before.without(deletedGroup));
  }

}
