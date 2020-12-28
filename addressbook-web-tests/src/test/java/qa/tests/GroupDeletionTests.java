package qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.model.GroupData;
import qa.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

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

      assertThat(after.size(), equalTo(before.size() -1));
      assertThat(after, equalTo(before.without(deletedGroup)));
  }

}
