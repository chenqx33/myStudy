package chenqx.leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

/**
 * @author chenqx 2020-02-28
 * @instruction
 */
public class Testa {
    @Test
    public void should_1() {
        System.out.println(replaceSpace(new StringBuffer("1 22 %")));
    }

    public String replaceSpace(StringBuffer str) {
        String s = str.toString().replaceAll("\\s", "%20");
        return s;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> result = new Stack<>();
        reverse(listNode, result);
        ArrayList<Integer> ss = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            ss.add(result.pop());
        }
        return ss;
    }

    public void reverse(ListNode listNode, Stack<Integer> result) {
        if (listNode == null) {
            return;
        }
        reverse(listNode.next, result);
        result.add(listNode.val);


    }

    @Test
    public void should_2() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println(printListFromTailToHead(listNode));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null;
        TreeNode root = new TreeNode(po[pre_root]);
        int i = dic.get(po[pre_root]);
        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }

    @Test
    public void should_4() {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int size = 0;

    public void push(int node) {
        size++;
        stack1.add(node);
    }

    public int pop() {
        for (int i = 0; i < size; i++) {
            stack2.add(stack1.pop());
        }
        int pop = stack2.pop();
        size--;
        for (int i = 0; i < size; i++) {
            stack1.add(stack2.pop());
        }

        return pop;
    }

    @Test
    public void should_5() {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        push(5);
        System.out.println(pop());
        System.out.println(pop());
    }

    @Test
    public void should_6() {
        System.out.println(NumberOf1(-1));
    }

    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n & 1) != 0) cnt++;
            n = n >>> 1;  //java没有unsigned关键字，>>>就是java中的无符号右移
        }
        return cnt;
    }

    @Test
    public void should_7() {
        Queue<Integer> j = new ArrayDeque<>();
        Queue<Integer> o = new ArrayDeque<>();
    }

    public void reOrderArray(int[] array) {

        Queue<Integer> j = new ArrayDeque<>();
        Queue<Integer> o = new ArrayDeque<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                j.add(array[i]);
            } else {
                o.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (j.size() > 0) {
                array[i] = j.poll();
            } else {
                array[i] = o.poll();
            }
        }
    }


    public static void main(String args[]) {
        int data[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        reverse(data);
        exchange(data);
        print1(data);
    }

    //将矩阵转置
    public static void reverse(int temp[][]) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = i; j < temp[i].length; j++) {
                int k = temp[i][j];
                temp[i][j] = temp[j][i];
                temp[j][i] = k;
            }
        }
    }

    //将转置后的矩阵的列交换（第一列跟最后一列交换，第二列跟倒数第二列交换）
    public static void exchange(int temp[][]) {
        int a = 0;
        int b = temp.length - 1;
        for (int i = 0; i < (temp.length) / 2; i++) {
            for (int j = 0; j < temp.length; j++) {
                int k = temp[j][a];
                temp[j][a] = temp[j][b];
                temp[j][b] = k;
            }
            a++;
            b--;
        }
    }

    //将矩阵输出
    public static void print1(int temp[][]) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + "\t");
            }
            System.out.println();
        }
    }


    @Test
    public void should_8() {
        int[][] arr = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
                new int[]{10, 11, 12}
        };
        spiralOrder(arr);

    }

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;
        int top = 0, bot = m - 1, left = 0, right = n - 1;      //设置上下左右界限
        int cnt = 0;
        int[] res = new int[m * n];

        while (top <= bot && left <= right) {                       //遍历matrix
            for (int j = left; j <= right; j++) {                   //从左到右
                res[cnt++] = matrix[top][j];
            }
            top++;
            for (int i = top; i <= bot; i++) {                      //从上到下
                res[cnt++] = matrix[i][right];
            }
            right--;
            for (int j = right; j >= left && top <= bot; j--) {         //从右到左
                res[cnt++] = matrix[bot][j];
            }
            bot--;
            for (int i = bot; i >= top && left <= right; i--) {         //从下到上
                res[cnt++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }

    @Test
    public void should_44() {
        ArrayList<Integer> objects = Lists.newArrayList();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.remove(1);
        System.out.println(objects.get(1));
    }


    @Test
    public void should_81() {
        int[][] arr = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
                new int[]{10, 11, 12}
        };
        spiralOrder1(arr);

    }

    public int[] spiralOrder1(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;
        int top = 0, bot = m - 1, left = 0, right = n - 1;      //设置上下左右界限
        int cnt = 0;
        int[] res = new int[m * n];

        while (top <= bot && left <= right) {                       //遍历matrix
            for (int j = left; j <= right; j++) {                   //从左到右
                res[cnt++] = matrix[top][j];
            }
            top++;
            for (int i = top; i <= bot; i++) {                      //从上到下
                res[cnt++] = matrix[i][right];
            }
            right--;
            for (int j = right; j >= left && top <= bot; j--) {         //从右到左
                res[cnt++] = matrix[bot][j];
            }
            bot--;
            for (int i = bot; i >= top && left <= right; i--) {         //从下到上
                res[cnt++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }

    @Test
    public void should_3() {
        int[] ints = {6, 5, 4, 8,4};
        int[] ints1 = smallerNumbersThanCurrent(ints);
        System.out.println();
    }


    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] helper = Arrays.copyOf(nums, nums.length);
        int[] result = Arrays.copyOf(nums, nums.length);
        Arrays.sort(helper);
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int i1 = 0; i1 < helper.length; i1++) {
                if (helper[i1]!=nums[i])sum++;
                if (helper[i1]==nums[i])break;
            }
            result[i]=sum;
        }

        return result;
    }
}
