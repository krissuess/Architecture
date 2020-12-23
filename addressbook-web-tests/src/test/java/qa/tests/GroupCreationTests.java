package qa.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import qa.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withName("test2").withFooter("").withHeader("");
        app.goTo().groupPage();
        app.group().create(group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() +1);

        int max = after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId();
        group.withId(max);
        before.add(group);
        Comparator<GroupData> byId = Comparator.comparingInt(   GroupData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}


