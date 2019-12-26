package chenqx.graph;

import chenqx.pojo.Book;
import com.google.common.collect.Lists;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenqx 2019-12-03
 * @instruction
 */
public class GraphTest {
    public static void main(String[] args) {
//        test();
//        test1();
        test2();

    }

//    private static void test() {
//        MutableGraph<Book> graph1 = GraphBuilder.directed()
//                .nodeOrder(ElementOrder.<Book>insertion())
//                .expectedNodeCount(10)
//                .allowsSelfLoops(false)
//                .build();
//        System.out.println(graph1);
//        graph1.putEdge(new Book("1","1"),new Book("2","2"));
//        graph1.putEdge(new Book("2","2"),new Book("1","1"));
//        System.out.println(Graphs.hasCycle(graph1));
//    }
//    private static void test1() {
//        MutableGraph<Integer> graph1 = GraphBuilder.directed()
//                .nodeOrder(ElementOrder.<Integer>insertion())
//                .expectedNodeCount(10)
//                .allowsSelfLoops(false)
//                .build();
//        System.out.println(graph1);
//        graph1.putEdge(1,2);
//        graph1.putEdge(2,3);
//        graph1.putEdge(3,4);
//        graph1.putEdge(4,1);
//        System.out.println(Graphs.hasCycle(graph1));
//    }
    private static void test2() {
        MutableGraph<String> graph1 = GraphBuilder.directed()
                .nodeOrder(ElementOrder.<String>insertion())
                .expectedNodeCount(10)
                .allowsSelfLoops(false)
                .build();
        System.out.println(graph1);
        graph1.putEdge("1","2");
        graph1.putEdge("2","3");
        graph1.putEdge("3","4");
        graph1.putEdge("4","1");
        graph1.addNode("10");
        graph1.removeNode("10");
        graph1.removeEdge("4","1");
        System.out.println(Graphs.hasCycle(graph1));

        System.out.println(graph1.nodes());
        System.out.println(graph1.edges());
    }
    @Test
    public void should_toMap(){
        ArrayList<Book> book = Lists.newArrayList(new Book("1","3"),new Book("1","6"));
        Map<String, String> collect = book.stream().collect(Collectors.toMap(o -> o.getAuth(), o -> o.getName()));
    }
    @Test
    public void should_ConcurrentModificationException() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        // 复现方法一
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }

        // 复现方法二
        iterator = arrayList.iterator();
        for (Integer value : arrayList) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }
    }
    @Test
    public void should_NPE(){
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
        ArrayList<Integer> integers2 = Lists.newArrayList(1, 2,4);
        integers2.removeAll(integers);
        System.out.println(integers2);
    }
}
