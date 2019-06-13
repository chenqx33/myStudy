package chenqx.pojo;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import joptsimple.internal.Strings;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CategoryTest1 {

    private CategoryObject categoryObject = new CategoryObject();
    Set<CategoryObject> categoryObjectList;

    @Before
    public void before() {

        categoryObjectList = Sets.newHashSet(
                new CategoryObject("1", "1", 1, 1, "", null),
                new CategoryObject("2", "2", 2, 1, "", null),
                new CategoryObject("3", "3", 3, 1, "", null),
                new CategoryObject("11", "11", 11, 1, "1", null),
                new CategoryObject("111", "111", 111, 1, "11", null),
                new CategoryObject("12", "12", 12, 1, "1", null),
                new CategoryObject("21", "21", 21, 1, "2", null),
                new CategoryObject("22", "22", 22, 1, "2", null)
        );

        categoryObject.setChildren(categoryObjectList.stream().filter(o -> Strings.isNullOrEmpty(o.getPid())).collect(Collectors.toList()));
        dealCurrentLevel(categoryObject, categoryObjectList);
    }

    @Test
    public void ss() {
        ArrayList<String> strings = Lists.newArrayList("1", "1");
        System.out.println(strings.removeIf(o -> o.equals("11")));

    }

    @Test
    public void test() {
        HashSet<Integer> ids = Sets.newHashSet(12, 21);
        Stack<Integer> stack = new Stack<>();
        remove(stack, categoryObject, ids);
        System.out.println("12");
    }


    public void remove(Stack<Integer> stack, CategoryObject categoryObject, HashSet<Integer> codes) {
        if (!codes.contains(categoryObject.getCode()) && categoryObject.getCode() != null) {
            stack.push(categoryObject.getCode());
        } else {
            stack.clear();
        }
        ;
        List<CategoryObject> children = categoryObject.getChildren();
        if (CollectionUtils.isNotEmpty(children)) {
            Iterator<CategoryObject> iterator = children.iterator();
            while (iterator.hasNext()){
                CategoryObject next = iterator.next();
                remove(stack, next, codes);
                if (!stack.isEmpty()){
                    Integer peek = stack.peek();
                    if (next.getCode().equals(peek)){
                        iterator.remove();
                        stack.pop();
                    }
                }

            }
        }


    }

    private void dealCurrentLevel(CategoryObject categoryObject, Set<CategoryObject> categoryObjectList) {
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
