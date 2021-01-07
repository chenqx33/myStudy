package chenqx.fs;

import com.google.common.collect.Maps;
import lombok.ToString;
import lombok.experimental.Delegate;

import java.util.Map;
import java.util.Objects;

/**
 * @author chenqx 2020-03-02
 * @instruction
 */
@ToString
public class DocumentBaseEntity implements Map<String, Object> {
    @Delegate
    protected Map<String, Object> data;

    public DocumentBaseEntity() {
        this.data = Maps.newLinkedHashMap();
    }

    public DocumentBaseEntity(Map<String,Object> data){
        Objects.requireNonNull(data);
        this.data = data;
    }

}
