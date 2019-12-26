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

    public static void main(String[] args) {
        POJO build = POJO.builder().ss(Lists.newArrayList()).build();
        System.out.println(build.getSs());
        System.out.println(new POJO().getSs());
    }
}
