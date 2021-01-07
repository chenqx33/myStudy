package chenqx.leetcode;

import org.junit.Test;

/**
 * @author chenqx 2020-02-26
 * @instruction
 */
public class CodeTest4 {
    @Test
    public void should_41() {
//        ArrayList<Integer> nums1 = Lists.newArrayList(1, 4, 5);
//        ArrayList<Integer> nums2 = Lists.newArrayList(1, 2, 3);

        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        int[] fu = new int[nums1.length + nums2.length];
        if (nums1.length == 0) {
            fu = nums2;
        }
        if (nums2.length == 0) {
            fu = nums1;
        }
        int index = 0;
        for (int i = 0, j = 0; i < nums1.length + nums2.length && nums1.length > 0 && nums2.length > 0; ) {
            if (nums1[i] < nums2[j]) {
                fu[index++] = nums1[i];
                i++;
            } else {
                fu[index++] = nums2[j];
                j++;
            }
            if (i == nums1.length || j == nums2.length) {
                if (i < nums1.length) {
                    while (i < nums1.length) {
                        fu[index++] = nums1[i];
                        i++;
                    }
                }
                if (j < nums2.length) {
                    while (j < nums2.length) {
                        fu[index++] = nums2[j];
                        j++;
                    }
                }
                break;
            }
        }
        double result;
        if (fu.length % 2 == 0) {
            result = (fu[(fu.length / 2 - 1)] + fu[(fu.length / 2)]) / 2.0;
        } else {
            result = fu[(fu.length / 2)];
        }
        System.out.println(result);
    }
}
