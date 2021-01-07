package chenqx.fs;

import java.util.Map;

/**
 * @author chenqx 2020-03-02
 * @instruction
 */
public class ObjectDataDocument extends DocumentBaseEntity {
    public ObjectDataDocument() {
    }
    private ObjectDataDocument(Map<String, Object> data) {
        super(data);
    }
    public static ObjectDataDocument of(Map<String, Object> data) {
        if (data == null) {
            return null;
        }
        return new ObjectDataDocument(data);
    }

}
