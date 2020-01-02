package chenqx.graph;

import chenqx.pojo.Book;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import org.junit.Test;

/**
 * @author chenqx 2019-12-03
 * @instruction  https://www.jianshu.com/p/78786a4f2cf1
 */
public class GraphTest {
//    public static void main(String[] args) {
//        test();
//        test1();
//        test2();
//
//    }
    @Test
    public void test() {
        MutableGraph<Book> graph1 = GraphBuilder.directed() //指定为有向图
                .nodeOrder(ElementOrder.<Book>insertion())  //节点按节点插入顺序输出
                .expectedNodeCount(10)                      //预期节点数
                .allowsSelfLoops(false)                     //是否允许子环
                .build();
        System.out.println(graph1);
        graph1.putEdge(new Book("1","1"),new Book("2","2"));
        graph1.putEdge(new Book("2","2"),new Book("1","1"));

        //判断是否成环
        System.out.println(Graphs.hasCycle(graph1));
    }
    @Test
    public void test1() {
        MutableGraph<Integer> graph1 = GraphBuilder.directed()
                .nodeOrder(ElementOrder.<Integer>insertion())
                .expectedNodeCount(10)
                .allowsSelfLoops(false)
                .build();
        System.out.println(graph1);
        graph1.putEdge(1,2);
        graph1.putEdge(2,3);
        graph1.putEdge(3,4);
        graph1.putEdge(4,1);
        System.out.println(Graphs.hasCycle(graph1));
    }


    @Test
    public void test2() {
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
        System.out.println(graph1);

        graph1.addNode("10");
        System.out.println(graph1);

        graph1.removeNode("10");
        System.out.println(graph1);

        graph1.removeEdge("4","1");
        System.out.println(graph1);
        System.out.println(Graphs.hasCycle(graph1));
        System.out.println(graph1.nodes());
        System.out.println(graph1.edges());
    }
}
