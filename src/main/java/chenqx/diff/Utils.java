package chenqx.diff;

import com.bytedance.cg.gcrm.common.util.JsonUtils;
import com.google.common.collect.Lists;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;

import java.util.Objects;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-14 21:03
 **/
public class Utils {
    public static void main(String[] args) {
        Pojo xiaoming = new Pojo("xiaoming", 12, "nan", Lists.newArrayList(new Pojo("xiaoxiaoming")));
        Pojo daming = new Pojo("daming", 12, null, Lists.newArrayList());
        DiffNode compare = ObjectDifferBuilder.buildDefault().compare(xiaoming, daming);
        StringBuffer sb = new StringBuffer();
        compare.visit((node, visit) -> {
            final Object baseValue = node.canonicalGet(xiaoming);
            final Object workingValue = node.canonicalGet(daming);
            if (node.getParentNode() == null|| node.getParentNode().getValueType() == Pojo.class
                    || node.getParentNode().getValueType() == Pojo.class) {
                if (Objects.isNull(baseValue) && Objects.nonNull(workingValue)) {
                    final String message = node.getPath() + " 新增 " +
                            JsonUtils.marshalToString(workingValue);
                    sb.append(message).append("\n");
                } else if (Objects.nonNull(baseValue) && Objects.isNull(workingValue)) {
                    final String message = node.getPath() + " 删除 " +
                            JsonUtils.marshalToString(baseValue);
                    sb.append(message).append("\n");
                } else if(!baseValue.equals(xiaoming)){
                    final String message = node.getPath() + " 从 " +
                            baseValue + " 变更成 " + workingValue;
                    sb.append(message).append("\n");
                }
            }
        }
        );
        System.out.println(sb.toString());

    }
}
