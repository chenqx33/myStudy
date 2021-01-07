package chenqx.pojo.heap;

import java.util.Arrays;

/**
 * @author chenqx 2020-03-02
 * @instruction
 */
public class Test {
    public static void downAdjus(int[] array, int parentIndex, int length) {
        int tmp = array[parentIndex];
        int maxChildIndex = parentIndex * 2 + 1;

        while (maxChildIndex < length) {
            if (maxChildIndex < length - 1 && array[maxChildIndex + 1] > array[maxChildIndex]) {
                maxChildIndex++;
            }
            if (parentIndex >= array[maxChildIndex]) {
                break;
            }
            array[parentIndex] = array[maxChildIndex];
            parentIndex = maxChildIndex;
            maxChildIndex = parentIndex * 2 + 1;

        }
        array[parentIndex] = tmp;
    }

    public static void buildHeap(int[] array) {
        //第一个i是最后一个非叶子节点，从最后一个非叶子节点开始，一次下沉调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjus(array, i, array.length);
        }
    }

    public static void heapSort(int[] array) {
        //1.把无序数组构建成二叉堆
        buildHeap(array);
        //2.循环删除对顶元素，移动到尾部，调节产生新的对顶
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjus(array, 0, i);
        }
    }

    public static void main(String[] args) {
//        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
//        upAdjust(array);
//        System.out.println(Arrays.toString(array));
//
//        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
//        buildHeap(array);
//        System.out.println(Arrays.toString(array));
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
