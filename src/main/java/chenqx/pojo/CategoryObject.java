package chenqx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryObject {
    private String id;
    private String name;
    private Integer code;
    private Integer orderField;
    private String pid;
    private List<CategoryObject> children;
}
