package chenqx.pojo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenqx 2019-12-12
 * @instruction
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class POJO {
    private List<String> ss = Lists.newArrayList();
    private boolean boo;

    public static void main(String[] args) {
        POJO pojo = new POJO();
        System.out.println(pojo.isBoo());
    }
}
