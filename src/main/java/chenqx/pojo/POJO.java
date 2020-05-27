package chenqx.pojo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author chenqx 2019-12-12
 * @instruction
 */
@Data
public class POJO {
    private List<Integer> ss;

    public static void main(String[] args) {
        POJO pojo = new POJO();
        Method[] methods = pojo.getClass().getMethods();

        System.out.println();
    }
}
