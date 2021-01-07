package chenqx.leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

/**
 * @author chenqx 2020-03-03
 * @instruction
 */
public class Test3_6 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void should_1() {
    }

    private List<Integer> maxDepth = new ArrayList<>();
    private boolean flag = true;

    private int former(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = former(root.left, depth + 1);
        int right = former(root.right, depth + 1);
        if (Math.abs(left - right) > 1) {
            flag = false;
            return 0;
        }
        return left > right ? left : right;

    }

    @Test
    public void should_3() {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int s = ss(array);
        int i = 0;
        for (; ; i++) {
            if ((s & 1) == 1) break;
            s = s >> 1;
        }
        ArrayList<Integer> helper1 = Lists.newArrayList();
        ArrayList<Integer> helper2 = Lists.newArrayList();
        for (int i1 : array) {
            if (((i1 >> i) & 1) == 1) {
                helper1.add(i1);
            } else {
                helper2.add(i1);

            }
        }
        num1[0] = ss1(helper1);
        num2[0] = ss1(helper2);
    }

    private int ss(int[] array) {
        int helper = 0;
        for (int i : array) {
            helper ^= i;
        }
        return helper;
    }

    private int ss1(List<Integer> array) {
        int helper = 0;
        for (int i : array) {
            helper ^= i;
        }
        return helper;
    }

    @Test
    public void should_4() {
        System.out.println(FindContinuousSequence(4));
        System.out.println(FindContinuousSequence(3));
        System.out.println(FindContinuousSequence(9));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = Lists.newArrayList();
        int leftIndex = 1;
        int rightIndex = 2;
        while (rightIndex <= (sum / 2) + 1) {
            int sumTodo = (leftIndex + rightIndex) * (rightIndex - leftIndex + 1) / 2;
            if (sumTodo > sum) leftIndex++;
            if (sumTodo < sum) rightIndex++;
            if (sumTodo == sum) {
                ArrayList<Integer> helper = new ArrayList<>();
                for (int i = leftIndex; i <= rightIndex; i++) {
                    helper.add(i);
                }
                result.add(helper);
                rightIndex++;
            }
        }
        return result;
    }

    @Test
    public void should_5() {
        System.out.println(FindNumbersWithSum(new int[]{1, 2, 3, 4, 5}, 6));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int minProduct = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int todoSum = array[leftIndex] + array[rightIndex];
            if (todoSum == sum) {
                if (leftIndex * rightIndex < minProduct) {
                    result.add(array[leftIndex]);
                    result.add(array[rightIndex]);
                    minProduct = leftIndex * rightIndex;
                }
                leftIndex++;
            }
            if (todoSum < sum) {
                leftIndex++;
            }
            if (todoSum > sum) {
                rightIndex--;
            }
        }
        return result;
    }


    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            queue.add(c);
        }
        for (int i = 0; i < n; i++) {
            Character poll = queue.poll();
            queue.add(poll);
        }
        StringBuilder stringBuilder = new StringBuilder();
        queue.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    @Test
    public void should_6() {
        System.out.println(LeftRotateString("abcd", 2));
    }

    public String ReverseSentence(String str) {
        if (str == null) return str;
        Stack<String> stack = new Stack<>();
        for (String s : str.split(" ")) {

            stack.add(s);
            stack.add(" ");
        }
        if (stack.size() == 0) return str;
        stack.pop();
        StringBuilder stringBuilder = new StringBuilder();
        while (stack.size() > 0) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    private String getString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stack.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    @Test
    public void should_7() {
        System.out.println(ReverseSentence("I am a student"));
    }

    public boolean isContinuous(int[] numbers) {
        Arrays.sort(numbers);
        int kingCount = 0;
        int difCount = 0;
        int pre = numbers[0] - 1;
        for (int number : numbers) {
            if (number == 0) {
                kingCount++;
            }

            if (pre != 0) {
                if (pre == number) {
                    difCount = 5;
                    break;
                }
                difCount += number - pre - 1;
            }
            pre = number;
        }
        return kingCount >= difCount;
    }

    @Test
    public void should_8() {
        System.out.println(isContinuous(new int[]{1, 3, 0, 5, 0}));
    }


    public int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> objects = Lists.newArrayList();
        int start = 0;
        for (int i = 0; i < n; i++) {
            objects.add(i);
        }
        while (objects.size() > 1) {
            int removeIndex;
            if ((start + m)% objects.size()==0) {
                removeIndex = objects.size()-1;
            } else {
                removeIndex = (start + m) % objects.size() - 1;
            }

            objects.remove(removeIndex);
            start = removeIndex == objects.size() ? 0 : removeIndex;
        }
        return objects.get(0);
    }

    @Test
    public void should_9() {
        System.out.println(LastRemaining_Solution(9, 13));
    }

    public int lastRemaining(int n, int m) {
        int last = 0;   //存活的最后一个人的位置
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
    @Test
    public void should_10(){
        int i = lastRemaining(5, 3);
        System.out.println(i);
    }

}

