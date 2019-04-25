package chenqx.stacktest;

import chenqx.utils.MinStack;
import org.junit.Test;

import java.util.Stack;

public class test {
    @Test
    public void t() {
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

    @Test
    public void kuohoa() {
        System.out.println(check("(())"));
    }

    @Test
    public void ss(){
        Integer calculation = calculation(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(calculation);
    }


    public boolean check(String str) {
        Stack stack = new Stack();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push("(");
                    break;
                case ')': {
                    if (stack.isEmpty()) return false;
                    else stack.pop();
                }
                ;
                break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }


    public int calculation(String[] arg) {
        Stack stack = new Stack();
        for (String s : arg) {
            if ("+-*/".contains(s)){
                switch (s) {
                    case "+": {
                        stack.push(Integer.valueOf(stack.pop().toString()) + Integer.valueOf(stack.pop().toString()));
                    }
                    ;
                    break;
                    case "-": {
                        Integer after = Integer.valueOf(stack.pop().toString());
                        Integer before = Integer.valueOf(stack.pop().toString());
                        stack.push(before-after );
                    }
                    ;
                    break;
                    case "*": {
                        stack.push(Integer.valueOf(stack.pop().toString()) * Integer.valueOf(stack.pop().toString()));
                    }
                    ;
                    break;
                    case "/": {
                        Integer after = Integer.valueOf(stack.pop().toString());
                        Integer before = Integer.valueOf(stack.pop().toString());
                        stack.push(before/after );
                    }
                    ;
                    break;
                }
            }else{
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop().toString());
    }

}
