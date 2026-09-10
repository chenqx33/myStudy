package chenqx.leetcode;

import scala.util.Left;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Solution_105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer, Integer> indexMap = new HashMap<>();
    int preindex = 0;

    public TreeNode myBuildTree(int[] preorder, int preorder_left, int preorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        int inorder_root = preorder[preindex++];

        TreeNode root = new TreeNode(inorder_root);

        int mid = indexMap.get(inorder_root);

        root.left = myBuildTree(preorder, preorder_left, mid-1);
        root.right = myBuildTree(preorder, mid+1, preorder_right);
        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, inorder.length-1);

    }
}
