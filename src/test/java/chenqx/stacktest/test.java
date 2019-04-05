package chenqx.stacktest;

import chenqx.utils.MinStack;
import org.junit.Test;

public class test {
    @Test
    public void t(){
        MinStack<Integer> stack = new MinStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(4);
        stack.push(7);
        stack.push(9);
        stack.push(1);
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
