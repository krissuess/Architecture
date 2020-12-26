package qa.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import qa.model.GroupData;
import qa.model.Groups;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2").withFooter("").withHeader("");
        app.goTo().groupPage();
        app.group().create(group);
        Groups after = app.group().all();
        Assert.assertEquals(after.size(), before.size() +1);
        group.withId(after.stream().mapToInt(x->x.getId()).max().getAsInt());
        Assert.assertEquals(after, before.withAdded(group));
    }
}


