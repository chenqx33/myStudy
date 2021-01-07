package chenqx.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.*;

/**
 * @author chenqx 2020-03-07
 * @instruction
 */
public class Test3_7 {
    @Test
    public void should_1() {
        System.out.println(Sum_Solution(100));
        System.out.println(Sum(100));
    }

    public int Sum_Solution(int n) {
        int result = 1;
        boolean tmp = n != 1 && (result = (n + Sum_Solution(n - 1))) == 1;
        return result;
    }

    private int Sum(int n) {
//        if (n==1)return 1;
//        return Sum(n-1)+n;
        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    public int Add(int num1, int num2) {
        int result = num1 ^ num2;
        int carry = num1 & num2;
        if (carry == 0) return result;
        return Add(result, carry << 1);
    }

    @Test
    public void should_2() {
        System.out.println(Add(10, 11));
    }

    public int StrToInt(String str) {
        long temp = 0;
        boolean ispositive = true;
        for (int i = 0; i < str.toCharArray().length; i++) {
            if (i == 0 && str.charAt(i) - '0' == -5) {
                continue;
            }
            if (i == 0 && str.charAt(i) - '0' == -3) {
                ispositive = false;
                continue;
            }
            if (str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9) {
                return 0;
            }
            temp = ispositive ? temp + (int) ((str.charAt(i) - '0') * (Math.pow(10, str.length() - i - 1)))
                    : temp - (int) ((str.charAt(i) - '0') * (Math.pow(10, str.length() - i - 1)));
            if (temp > Integer.MAX_VALUE) {
                temp = 0;
                break;
            }
            if (temp < Integer.MIN_VALUE) {
                temp = 0;
                break;
            }
        }

        return (int) temp;
    }

    @Test
    public void should_3() {
        System.out.println(StrToInt("-2147483649"));
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                duplication[0] = number;
                return true;
            }
        }
        return false;
    }

    public int[] multiply(int[] A) {
        int temp = 1;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = temp;
            temp *= A[i];
        }
        temp = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= A[i];
        }
        return result;
    }

    @Test
    public void should_4() {
        System.out.println(Arrays.toString(multiply(new int[]{1, 2, 3, 4, 5})));
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        {
            boolean firstMath;
            firstMath = !s.isEmpty() && ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) ||
                        (firstMath && isMatch(s.substring(1), p));
            } else {
                return firstMath && isMatch(s.substring(1), p.substring(1));
            }

        }
    }


    @Test
    public void should_5() {

    }

    public boolean match(char[] str, char[] pattern) {
        String s = "", p = "";
        for (char c : str) {
            s += c;
        }
        for (char pc : pattern) {
            p += pc;
        }
        if (p.isEmpty()) return s.isEmpty();
        {
            boolean firstMath;
            firstMath = !s.isEmpty() && ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) ||
                        (firstMath && isMatch(s.substring(1), p));
            } else {
                return firstMath && isMatch(s.substring(1), p.substring(1));
            }

        }
    }

    public boolean isNumeric(char[] str) {
        StringBuilder s = new StringBuilder();
        for (char c : str) {
            s.append(c);
        }
        return s.toString().matches("^[+-]?(\\.\\d+|\\d+\\.?\\d*)([eE][+-]?\\d+)?$");
    }

    @Test
    public void should_6() {
        System.out.println(isNumeric(new char[]{'1'}));
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = pHead;
        ListNode pre = null;
        Map<Integer, Integer> helper = new HashMap<>();
        while (pHead != null) {
            if (!helper.containsKey(pHead.val)) {
                helper.put(pHead.val, 1);
            } else {
                helper.computeIfPresent(pHead.val, (k, o) -> o + 1);
            }
            pHead = pHead.next;
        }

        pHead = head;
        while (pHead != null) {
            if (helper.get(pHead.val) > 1) {
                if (pre == null) {
                    head = pHead.next;
                } else {
                    pre.next = pHead.next;
                }
            } else {
                pre = pHead;
            }

            pHead = pHead.next;
        }
        if (pre == null) head = null;
        return head;
    }

    @Test
    public void should_7() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node44 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node33 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node33;
        node33.next = node4;
        node4.next = node44;
        node44.next = node5;
        deleteDuplication(node1);
        System.out.println();
    }

    @Test
    public void should_71() {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        node4.next = node5;
        deleteDuplication(node4);
        System.out.println();
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode == pNode.next.left) return pNode.next;
            pNode = pNode.next;
        }

        return null;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        String leftStr = DFS(pRoot, true);
        String rightStr = DFS(pRoot, true);
        return leftStr.equals(rightStr);
    }

    private String DFS(TreeNode root, boolean flag) {
        if (root == null) return "";
        String result = "";
        result = flag ? root.val + DFS(root.left, flag) + DFS(root.right, flag)
                : root.val + DFS(root.right, flag) + DFS(root.left, flag);
        return result;

    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> helper = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper.offer(pRoot);
        boolean rev = true;
        while (!helper.isEmpty()) {
            int size = helper.size();
            ArrayList<Integer> fu = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = helper.poll();
                if (poll == null) continue;
                if (rev) fu.add(poll.val);
                else fu.add(0, poll.val);
                helper.add(poll.left);
                helper.add(poll.right);
            }
            if (!fu.isEmpty()) result.add(fu);
            rev = !rev;
        }
        return result;
    }

    String Serialize(TreeNode root) {
        if (root == null) return "$,";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val).append(",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        index++;
        if (str == null || str.isEmpty()) return null;
        String[] split = str.split(",");
        TreeNode treeNode = null;
        if (!split[index].equals("$")) {
            treeNode = new TreeNode(Integer.parseInt(split[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }

    int minIndex = 0;
    TreeNode minK;

    void KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return;
        KthNode(pRoot.left, k);
        minIndex++;
        if (minIndex == k) minK = pRoot;
        KthNode(pRoot.right, k);
    }

    @Test
    public void should_88() {
    }

    private List<Integer> helper = new ArrayList<>();

    public void Insert(Integer num) {
        helper.add(num);
    }

    public Double GetMedian() {
        int size = helper.size();
        Collections.sort(helper);
        if ((size & 1) == 1) {
            return helper.get(size / 2).doubleValue();
        } else {
            return (helper.get(size / 2 - 1) + helper.get(size / 2)) / 2.0;
        }
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        int endIndex = size - 1;
        ArrayList<Integer> objects = Lists.newArrayList();
        ArrayList<Integer> result = Lists.newArrayList();
        for (int i = 0; i <= endIndex; i++) {
            objects.add(num[i]);
        }
        while (endIndex < num.length) {
            Integer integer = objects.stream().min((o1, o2) -> o2 - o1).get();
            result.add(integer);
            if (endIndex == num.length - 1) break;
            objects.remove(0);
            objects.add(num[++endIndex]);
        }
        return result;
    }

    @Test
    public void should_99() {
        int[] list = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxInWindows(list, 3));
    }

    private Set<String> ss = Sets.newHashSet();

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "", 0);
            }
        }
        return false;
    }

    void dfs(char[][] board, int i, int j, String stringBuilder, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return;
        }

        if (board[i][j] == '/') return;
        stringBuilder += board[i][j];
        stringBuilder += "/";
        if (k == 3) ss.add(stringBuilder.toString());
        char tmp = board[i][j];
        board[i][j] = '/';
        dfs(board, i + 1, j, stringBuilder, k + 1);
        dfs(board, i - 1, j, stringBuilder, k + 1);
        dfs(board, i, j + 1, stringBuilder, k + 1);
        dfs(board, i, j - 1, stringBuilder, k + 1);
        board[i][j] = tmp;
    }

    @Test
    public void should_11() {
        char[][] a = new char[2][];
        char[] b = {'1', '2'};
        char[] c = {'3', '4'};
        a[0] = b;
        a[1] = c;
        exist(a, "");
        System.out.println(ss);

    }


    int kk = 0;

    void dfs1(int[][] board, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return;
        }
        if (sum(i, j) > k) return;
        if (board[i][j] == -1) return;
        board[i][j] = -1;
        kk++;
        dfs1(board, i + 1, j, k);
        dfs1(board, i - 1, j, k);
        dfs1(board, i, j + 1, k);
        dfs1(board, i, j - 1, k);
    }

    private int sum(int i, int j) {
        int result = 0;
        for (char c : String.valueOf(i).toCharArray()) {
            result += (c - '0');
        }
        for (char c : String.valueOf(j).toCharArray()) {
            result += (c - '0');
        }
        return result;
    }

    @Test
    public void should_12() {
        int[][] arg = new int[10][10];
        dfs1(arg, 0, 0, 5);
        System.out.println(kk);
    }

    private int cutRope(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
        }
        return cutRopeCore(i);

    }


    private int cutRopeCore(int num) {
        if (num < 4) return num;
        int max = 0;
        for (int i = 1; i <= num / 2; i++) {
            max = Math.max(max, cutRopeCore(i) * cutRopeCore(num - i));
        }
        return max;
    }

    private int cutRope1(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
        }
        int[] helper = new int[i + 1];
        helper[0] = 0;
        helper[1] = 1;
        helper[2] = 2;
        helper[3] = 3;
        for (int i1 = 4; i1 <= i; i1++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(helper[j] * helper[i1 - j], max);
            }
            helper[i1] = max;
        }
        return helper[i];

    }

    private int cutRope2(int number) {
        if (number < 2)
            return 0;
        if (number == 2)
            return 1;
        if (number == 3)
            return 2;
        int timesOf3 = number / 3;
        if ((number - timesOf3 * 3) == 1)
            timesOf3 -= 1;
        int timesOf2 = (number - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    private int cutRope3(int number) {
        if (number < 2)
            return 0;
        if (number == 2)
            return 1;
        if (number == 3)
            return 2;
        int timesOf3 = number / 3;
        int timesOf2 = 2;
        if (number % 3 == 1)
            timesOf3 -= 1;
        if (number % 3 == 2)
            timesOf2 = 1;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    @Test
    public void should_13() {
        System.out.println(cutRope(8));
        System.out.println(cutRope1(8));
        System.out.println(cutRope2(8));
        System.out.println(cutRope3(8));
    }

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    @Test
    public void should_44(){
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3);
        for (Integer integer : list) {
            list.remove(integer);
        }
    }
}
