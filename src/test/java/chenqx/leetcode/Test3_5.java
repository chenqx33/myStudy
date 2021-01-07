package chenqx.leetcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author chenqx 2020-03-03
 * @instruction
 */
public class Test3_5 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int index = -1;

        String Serialize(TreeNode head) {
            StringBuilder stringBuilder = new StringBuilder();

            if (head == null) {
                stringBuilder.append("$,");
                return stringBuilder.toString();
            }
            stringBuilder.append(head.val).append(",");
            stringBuilder.append(Serialize(head.left));
            stringBuilder.append(Serialize(head.right));
            return stringBuilder.toString();
        }

        TreeNode Deserialize(String s) {
            index++;
            if (s == null) return null;
            String[] stringArray = s.split(",");
            TreeNode node = null;
            if (!stringArray[index].equals("$")) {
                node = new TreeNode(Integer.parseInt(stringArray[index]));
                node.left = Deserialize(s);
                node.right = Deserialize(s);
            }
            return node;

        }
    }

    @Test
    public void should_1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node2.left = node1;
        TreeNode node3 = new TreeNode(3);
        node3.left = node2;
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        node6.left = node4;
        node3.right = node6;
        System.out.println(sum(node3));
//        System.out.println(new Solution().Serialize(node3));
//
//        TreeNode deserialize = new Solution().Deserialize(new Solution().Serialize(node3));
//        System.out.println();
    }

    private int sum(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        int sum1 = sum(root.left);
        int sum2 = sum(root.right);
        if (sum1+sum2>3) throw new RuntimeException("超长");
        return sum1 + sum2 + 1;

    }

    @Test
    public void should_2() {
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> objects = new ArrayList<>();
        ListNode headAHelper = headA;
        ListNode headBHelper = headB;

        while (headAHelper != null) {
            objects.add(headA);
            headAHelper = headAHelper.next;
        }
        while (headBHelper != null) {
            if (objects.contains(headBHelper)) {
                return headBHelper;
            }
            headBHelper = headBHelper.next;
        }
        return null;
    }

    @Test
    public void should_3() {
        int search = search(new int[]{4, 4, 4}, 4);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int result = 0;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (nums[mid] < target) {
                leftIndex++;
            } else if (nums[mid] > target) {
                rightIndex--;
            } else {
                int leftI = mid;
                int rightI = mid + 1;
                while (leftI >= leftIndex && nums[leftI--] == target) {
                    result++;
                }
                while (rightI <= rightIndex && nums[rightI++] == target) {
                    result++;
                }
                break;
            }
        }
        return result;
    }

    //三进制
    int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : nums) {
                if (((1 << i) & n) != 0) count++;
            }
            if (count % 3 == 1) ans += (1 << i);
        }
        return ans;
    }

    //状态机  https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/san-jin-zhi-zhuang-tai-ji-by-muyids/
    int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    @Test
    public void should_33() {
        System.out.println(migBomSql("1", 10));
    }

    public static String migBomSql(String tenantId, int j) {
        String sql = "SELECT id                     AS _id,\n" +
                "       name,\n" +
                "       tenant_id,\n" +
                "       order_field,\n" +
                "       'BOMObj'               AS object_describe_api_name,\n" +
                "       '0123456789'           AS object_describe_id,\n" +
                "       'default__c'           AS record_type,\n" +
                "       lookup_prod_catalog_id as product_group_id,\n" +
                "       lookup_product_id      as product_id,\n" +
                "       adjust_price,\n" +
                "       amount,\n" +
                "       is_required,\n" +
                "       selected_by_default,\n" +
                "       price_editable,\n" +
                "       amount_editable,\n" +
                "       min_amount,\n" +
                "       max_amount,\n" +
                "       increment,\n" +
                "       enabled_status,\n" +
                "       master_product_id      as parent_product_id,\n" +
                "       remark\n" +
                "FROM sub_product\n" +
                "WHERE tenant_id = '%s'\n" +
                "  and is_deleted = 0\n" +
                "ORDER BY id\n" +
                "OFFSET %s\n" +
                "LIMIT 500";
        return String.format(sql, tenantId, j);
    }

}
