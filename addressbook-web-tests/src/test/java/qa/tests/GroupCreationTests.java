package qa.tests;

import org.testng.annotations.*;
import qa.model.GroupData;
import qa.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2").withFooter("").withHeader("");
        app.goTo().groupPage();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()+1));
        Groups after = app.group().all();
        group.withId(after.stream().mapToInt(x->x.getId()).max().getAsInt());
        assertThat(after, equalTo(before.withAdded(group)));
    }

    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2'").withFooter("").withHeader("");
        app.goTo().groupPage();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}


