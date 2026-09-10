package chenqx.leetcode;

import java.util.Stack;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/8 15:30
 *
 **/
public class MyQueue {
    private Stack<Integer> inStack, outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.empty()){
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.empty()){
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
    void in2out(){
        while (!inStack.empty()){
            outStack.push(inStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
    }
}
