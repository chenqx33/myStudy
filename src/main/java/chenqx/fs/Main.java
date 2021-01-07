package chenqx.fs;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author chenqx 2020-03-02
 * @instruction
 */
public class Main {
    @Test
    public void should_1() {
        String arg = "[{\"object_describe_api_name\":\"BOMObj\",\"product_id\":\"123\",\"_id\":\"1\",\"children\":[{\"object_describe_api_name\":\"BOMObj\",\"_id\":\"3\",\"product_id\":\"abc\",\"children\":[{\"object_describe_api_name\":\"BOMObj\",\"_id\":\"4\",\"product_id\":\"def\"}]},{\"object_describe_api_name\":\"ProductGroupObj\",\"_id\":\"2\",\"children\":[{\"object_describe_api_name\":\"BOMObj\",\"_id\":\"3\",\"product_id\":\"456\"}]}]}]";
        List<ObjectDataDocument> bomTreeList = JSON.parseArray(arg, ObjectDataDocument.class);
        ArrayList<ObjectDataDocument> bomList = Lists.newArrayList();
        ArrayList<ObjectDataDocument> groupList = Lists.newArrayList();
        recursive(null, bomTreeList, bomList, groupList, Lists.newArrayList("root"), Lists.newArrayList("_id"), "root", "root", null);
        System.out.println(bomList);
        System.out.println(groupList);

    }

    private void recursive(Object user, List<ObjectDataDocument> bomTreeList, List<ObjectDataDocument> bomList, List<ObjectDataDocument> groupList, List<String> productPath, List<String> bomPath, String rootProductId, String parentProductId, String groupId) {
        for (ObjectDataDocument node : bomTreeList) {
            node.put(BomConstants.FIELD_PARENT_PRODUCT_ID, parentProductId);
            if (Objects.isNull(node.get("_id"))) {
//                node.put(IObjectData.ID, serviceFacade.getSeqId(user.getTenantId(), "BOMObj"));
            }

            if ("BOMObj".equals(node.get("object_describe_api_name"))) {
                productPath.add(node.get("product_id").toString());
                bomPath.add(node.get("_id").toString());
                node.put(BomConstants.FIELD_ROOT_PRODUCT_ID, rootProductId);

            }
            if (Objects.nonNull(node.get("children"))) {
                if ("BOMObj".equals(node.get("object_describe_api_name"))) {
                    recursive(null, JSON.parseArray(node.get("children").toString(), ObjectDataDocument.class), bomList, groupList, productPath, bomPath, rootProductId, node.get(BomConstants.FIELD_PRODUCT_ID).toString(), null);
                } else {
                    recursive(null, JSON.parseArray(node.get("children").toString(), ObjectDataDocument.class), bomList, groupList, productPath, bomPath, rootProductId, parentProductId, node.get("_id").toString());
                }
            }
            if ("BOMObj".equals(node.get("object_describe_api_name"))) {
                node.put("product_group_id", groupId);

                node.remove("children");
                bomList.add(node);
                node.put("product_path", Joiner.on(".").join(productPath));
                productPath.remove(node.get("product_id").toString());


                node.put("bom_path", Joiner.on(".").join(bomPath));
                bomPath.remove(node.get("_id").toString());
            } else {
                node.remove("children");
                groupList.add(node);
            }

        }
    }
}
