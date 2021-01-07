package chenqx.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;

/**
 * @author chenqx 2020-02-29
 * @instruction
 */
public class Guilv {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int preIndex = 0;
        for (int i = 0; i < popped.length; i++) {
            for (int j = 0; j < pushed.length; j++) {

                if (popped[i] == pushed[j]) {
                    if (i > 0) {
                        if (j < preIndex) {
                            for (int k = j + 1; k < preIndex; k++) {
                                if (pushed[k] != -1) return false;
                            }
                        }
                    }
                    pushed[j] = -1;
                    preIndex = j;
                }
            }
        }


        return true;
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0) return true;
        int preIndex = 0;
        for (int i = 0; i < popA.length; i++) {
            for (int j = 0; j < pushA.length; j++) {

                if (popA[i] == pushA[j]) {
                    if (i > 0) {
                        if (j < preIndex) {
                            for (int k = j + 1; k < preIndex; k++) {
                                if (pushA[k] != -1) return false;
                            }
                        }
                    }
                    pushA[j] = -1;
                    preIndex = j;
                }
            }
        }
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] != -1) return false;
        }
        return true;

    }

    @Test
    public void should_1() {
        boolean b = validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2});
        System.out.println(b);
    }


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> fu = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        fu.add(root);
        while (true) {
            int size = fu.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode poll = fu.poll();
                    if (poll.left != null) fu.add(poll.left);
                    if (poll.right != null) fu.add(poll.right);
                    result.add(poll.val);
                }
            } else {
                break;
            }

        }
        return result;

    }

    public void ss(TreeNode root, ArrayList<Integer> result) {
        List<Object> objects = Lists.newArrayList();
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        findPath(new ArrayList<Integer>(), root, target, 0, lists);
        return lists;
    }

    /*
     * path:用于存放当前节点所在的路径（随着遍历一直在变动）
     */
    private static void findPath(ArrayList<Integer> path, TreeNode node, int sum, int tempSum, ArrayList<ArrayList<Integer>> lists) {
        //到当前节点位置的路径的节点值的和
        tempSum += node.val;
        //
        path.add(node.val);
        if (tempSum == sum && node.left == null && node.right == null) {
            //得到一个符合要求的路径时，创建一个新的ArrayList，拷贝当前路径到其中，并添加到lists中
            lists.add(new ArrayList(path));
        }
        if (node.left != null) {
            findPath(path, node.left, sum, tempSum, lists);
            //递归结束时，该留的路径已经记录了，不符合的路径也都不用理，删掉当前路径节点的值
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            findPath(path, node.right, sum, tempSum, lists);
            //递归结束时，该留的路径已经记录了，不符合的路径也都不用理，删掉当前路径节点的值
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void should_() {
        Map<Object, Object> objectObjectHashMap = Maps.newHashMap();
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node cur = root;
        Node before = null;
        Node after;
        Node head = null;

        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            stack.add(cur);
            head = cur;
            cur = cur.left;
        }

        while (!stack.isEmpty()) {
            cur = stack.pop();
            Node temp = cur.right;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (stack.isEmpty())
                after = head;
            else
                after = stack.peek();
            cur.left = before;
            cur.right = after;
            before = cur;
        }
        head.left = before;
        return head;
    }

    @Test
    public void should_2() {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2, node1, node3);
        Node node5 = new Node(5);
        Node node4 = new Node(4, node2, node5);
        Node node = Convert(node4);
        System.out.println();
    }

    Node pre = null;

    public Node Convert(Node pRootOfTree) {
        if (pRootOfTree == null) return pRootOfTree;
        Node p = pRootOfTree, q = pRootOfTree;
        while (p.left != null) p = p.left;
        while (q.right != null) q = q.right;
        inorder(pRootOfTree);
        p.left = q;
        q.right = p;
        return p;
    }

    public void inorder(Node curr) {
        if (curr == null) return;
        inorder(curr.left);
        curr.left = this.pre;
        if (this.pre != null) this.pre.right = curr;
        pre = curr;

        inorder(curr.right);
    }


    List<String> res = new ArrayList<String>();

    public void helper(StringBuilder S, StringBuilder builder) {
        if (S.length() == 0) {
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (S.indexOf(String.valueOf(c)) == i) {
                builder.append(c);
                S.deleteCharAt(i);
                helper(S, builder);
                S.insert(i, c);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    public String[] permutation(String S) {
        helper(new StringBuilder(S), new StringBuilder());
        String[] s = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            s[i] = res.get(i);
        }
        return s;
    }

    @Test
    public void should_3() {
        String[] abcs = permutation("abcd");
        for (String abc : abcs) {
            System.out.println(abc);
        }
    }
    @Test
    public void should_4(){
        Permutation("abc");
    }

    ArrayList<String> result = new ArrayList<>();
    public void Permutation(String str) {
        helper1(new StringBuilder(str),new StringBuilder());
        System.out.println(result);

    }

    public void helper1(StringBuilder str,StringBuilder stringBuffer){
        if(str.length()==0){
            result.add(stringBuffer.toString());
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (str.indexOf(String.valueOf(c))==i){
                stringBuffer.append(c);
                str.deleteCharAt(i);
                helper1(str,stringBuffer);
                str.insert(i,c);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }
    }

}
