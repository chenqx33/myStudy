package chenqx.leetcode;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/10 11:26
 *
 **/
public class Solution_198 {
    public int rob(int[] nums) {
        if (nums==null)return 0;
        if (nums.length==1) return nums[0];
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        int max = f[1];

        for (int i = 2; i < n; i++) {
            f[i] = Math.max(f[i-1], f[i-2]+nums[i]);
            if (max<f[i]) max = f[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_198().rob(new int[]{1,2,3,1}));
    }
}
