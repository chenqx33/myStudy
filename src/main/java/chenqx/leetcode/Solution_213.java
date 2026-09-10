package chenqx.leetcode;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/10 11:26
 *
 **/
public class Solution_213 {
    public int rob(int[] nums) {
        if (nums==null)return 0;
        if (nums.length==1) return nums[0];
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        int max = f[0];
        int max1 = f[1];

        for (int i = 2; i < n-1; i++) {
            f[1] = f[0];
            f[i] = Math.max(f[i-1], f[i-2]+nums[i]);
            if (max<f[i]) max = f[i];
        }
        for (int i = 2; i < n; i++) {
            f[0] = 0;
            f[1] = nums[1];
            f[i] = Math.max(f[i-1], f[i-2]+nums[i]);
            if (max1<f[i]) max1 = f[i];
        }
        return Math.max(max,max1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_213().rob(new int[]{2,3,2}));
    }
}
