package chenqx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String auth;
    private String name;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("\"auth\":").append("\"").append(auth)
                .append("\"").append(",").append("\"name\"").append("\"").append(name).append("\"").append("}");
        return sb.toString();
    }
}
