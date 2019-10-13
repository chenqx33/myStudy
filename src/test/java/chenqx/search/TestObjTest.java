package chenqx.search;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author chenqx 2019-10-13
 * @instruction
 */
public class TestObjTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void fastJson() {
        TestObj parse = JsonHelper.parseByFastJson("{\"parentList\":[{\"name\":\"1\"}],\"parent2List\":[{\"name\":\"1\"}],\"name\":\"22\"}");
        assert parse.getParentList().get(0).getName().equals("1");
        parse.getParent2List().get(0).setName("2");
        assert parse.getParent2List().get(0).getName().equals("2");
    }

    @Test
    public void gson_error() {
        thrown.expectMessage("Unable to invoke no-args constructor for interface chenqx.search.Parent2. Registering an InstanceCreator with Gson for this type may fix this problem.");
        JsonHelper.parseByGson("{\"parentList\":[{\"name\":\"1\"}],\"parent2List\":[{\"name\":\"1\"}],\"name\":\"22\"}");
    }

    @Test
    public void gson_OK() {
        TestObj parse = JsonHelper.parseByGson("{\"parentList\":[{\"name\":\"1\"}],\"name\":\"22\"}");
        assert parse.getParentList().get(0).getName().equals("1");
    }

}
