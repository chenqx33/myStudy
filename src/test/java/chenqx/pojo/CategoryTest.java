package chenqx.pojo;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CategoryTest {

    private CategoryObject categoryObject = new CategoryObject();
    Set<CategoryObject> categoryObjectList;
    @Before
    public void before(){

        categoryObjectList = Sets.newHashSet(
                new CategoryObject("1","1",1,1,"", null),
                new CategoryObject("2","2",2,1,"", null),
                new CategoryObject("3","3",3,1,"", null),
                new CategoryObject("11","11",11,1,"1", null),
                new CategoryObject("111","111",111,1,"11", null),
                new CategoryObject("12","12",12,1,"1", null),
                new CategoryObject("21","21",21,1,"2", null),
                new CategoryObject("22","22",22,1,"2", null)
        );

        categoryObject.setChildren(categoryObjectList.stream().filter(o -> o.getPid() == null).collect(Collectors.toList()));
//        dealCurrentLevel(categoryObject, categoryObjectList);
    }

    @Test
    public void test(){
        HashSet<String> ids = Sets.newHashSet("111","21","22");
        Map<String, String> collect = categoryObjectList.stream().collect(Collectors.toMap(o -> o.getId(), o -> o.getPid()));
        HashSet<String> objects = Sets.newHashSet();
        for (String id : ids) {
            getDepth(collect,id,objects);
        }
        objects.remove("");
        System.out.println(objects.toString());
    }


    private Set<String> getDepth(Map<String, String> idToPid, String id,Set<String> ids) {
        ids.add(id);
        if (!idToPid.containsKey(id)) {
            return ids;
        }
        return getDepth(idToPid, idToPid.get(id),ids);

    }


    public void remove(Stack<Integer> stack,CategoryObject categoryObject,HashSet<Integer> codes){
        if (codes.contains(categoryObject.getCode())){
            stack.clear();
        }else {
            if (stack.isEmpty()){
                stack.push(categoryObject.getCode());
            }
        }
        if (CollectionUtils.isNotEmpty(categoryObject.getChildren())){
            for (CategoryObject child : categoryObject.getChildren()) {
                remove(stack,child,codes);
            }
            categoryObject.getChildren().removeIf(o->codes.contains(o.getCode()));
        }

    }

    private void dealCurrentLevel(CategoryObject categoryObject, List<CategoryObject> categoryObjectList) {
        List<CategoryObject> children = categoryObject.getChildren();
        if (CollectionUtils.isNotEmpty(children)) {

            for (CategoryObject child : children) {
                List<CategoryObject> collect = categoryObjectList.stream().filter(o -> child.getId().equals(o.getPid())).sorted(Comparator.comparingInt(CategoryObject::getOrderField)).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(collect)) {
                    child.setChildren(collect);
                }
                dealCurrentLevel(child, categoryObjectList);
            }
        }

    }
}
