package chenqx.leetcode;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenqx 2020-03-10
 * @instruction
 */
public class Test3_10 {
    @Test
    public void should_1() {
        int[] arr = {4, 5, 6, 1, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] array, int low, int high) {
        int i = low, j = high;
        int tmp = array[low];
        if (low > high) {
            return;
        }
        while (i < j) {
            while (tmp >= array[i] && i < j) {
                i++;
            }
            while (tmp <= array[j] && i < j) {
                j--;
            }
            if (i < j) {
                int i1 = array[i];
                int j1 = array[j];
                array[j] = i1;
                array[i] = j1;
            }
        }
        array[low] = array[i];
        array[i] = tmp;
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, j);
    }

    @Test
    public void should_2() {
        System.out.println(findLengthOfLCIS(new int[]{1, 4, 2, 3}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    @Test
    public void should_3() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>(10);
        Class<? extends ArrayList> aClass = list.getClass();
        Field elementData = aClass.getDeclaredField("elementData");
        elementData.setAccessible(true);
        Object[] ele = (Object[]) elementData.get(list);
        System.out.println(ele.length);
        System.out.println(list.size());

    }

    class Test1 {


        private String name;
        private int age;

        private Test1(int age) {
            this.age = age;
        }

        private void speak(String name, String id) {
            System.out.println("我的名字是:" + name + id);
        }

        public Test1(String name) {
            this.name = name;
        }
    }

    @Test
    public void should_5() {
        Test1 test1 = new Test1("张三");

        Method[] methods = Test1.class.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            methods[i].setAccessible(true);
            try {
                methods[i].invoke(test1, "成功调用", "123");
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(methods[i].getName());
        }
    }

    private int result = -1;

    @Test
    public void should_55() {
        int[] array = {1, 3, 3, 4, 4, 4, 4, 5, 6, 7};
        getNumb(array, 0, array.length - 1, 4);
        System.out.println(result);
    }

    private void getNumb(int[] array, int low, int high, int k) {
        if (low > high) return;
        int mid = (high + low) / 2;
        if (array[mid] == k) {
            if (array[mid + 1] != k) {
                result = mid;
                return;
            }
            getNumb(array, mid + 1, high, k);
        }
        if (array[mid] > k) {
            getNumb(array, low, mid - 1, k);
        }
        if (array[mid] < k) {
            getNumb(array, mid + 1, high, k);
        }
    }

}
