package chenqx.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenqx
 * @date 2019-09-24 16:35
 * @instruction
 */
public class ListUtils {
    public static List removeAll(List src, List oth) {
        LinkedList result = new LinkedList(src);//大集合用linkedlist
        HashSet othHash = new HashSet(oth);//小集合用hashset
        Iterator iter = result.iterator();//采用Iterator迭代器进行数据的操作
        while (iter.hasNext()) {
            if (othHash.contains(iter.next())) {
                iter.remove();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long step1 = System.currentTimeMillis();
        List<String> all = new Random().ints(1, 999999).mapToObj(String::valueOf).distinct().limit(160000).collect(Collectors.toList());
        List<String> needRemove = new Random().ints(1, 999999).mapToObj(String::valueOf).distinct().limit(110000).collect(Collectors.toList());
        long step2 = System.currentTimeMillis();
        System.out.println(step2 - step1);
        ListUtils.removeAll(all, needRemove);
        System.out.println(System.currentTimeMillis()-step2);

    }
}
