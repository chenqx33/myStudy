package chenqx.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenqx 2020-02-28
 * @instruction
 */
public class Testb {
    private int[] data = new int[100];
    private Stack<Integer> minIndex = new Stack<>();
    private int size = 0;

    public void push(int node) {
        data[size] = node;
        if (minIndex.size() == 0) {
            minIndex.add(size);
        } else {
            if (node < data[minIndex.peek()]) {
                minIndex.add(size);
            }
        }
        size++;
    }

    public void pop() {
        data[size - 1] = 0;
        size--;
        if (minIndex.peek() == size) {
            minIndex.pop();
        }
    }

    public int top() {
        return data[size];
    }

    public int min() {
        return data[minIndex.peek()];
    }

    @Test
    public void should_1() {
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());

        push(2);
        System.out.println(min());

        push(3);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        push(0);

        System.out.println(min());
    }



    public int maxSubArray(int[] nums) {
        List<Integer> sums =new ArrayList<>();
        int sum = 0;
        for(int i=0,j=0;i<nums.length;i++){
            sum+=nums[i];
            sums.add(sum);
            if(sum<0)sum=0;
        }
        sums.sort(Integer::compareTo);
        return sums.get(sums.size()-1);
    }

    @Test
    public void should_2(){
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
    private int dfs(int n) {
        if (n <= 0) {
            return 0;
        }

        String numStr = String.valueOf(n);
        int high = numStr.charAt(0) - '0';
        int pow = (int) Math.pow(10, numStr.length() - 1);
        int last = n - high * pow;

        if (high == 1) {
            // 最高位是1，如1234, 此时pow = 1000,那么结果由以下三部分构成：
            // (1) dfs(pow - 1)代表[0,999]中1的个数;
            // (2) dfs(last)代表234中1出现的个数;
            // (3) last+1代表固定高位1有多少种情况。
            return dfs(pow - 1) + dfs(last) + last + 1;
        } else {
            // 最高位不为1，如2234，那么结果也分成以下三部分构成：
            // (1) pow代表固定高位1，有多少种情况;
            // (2) high * dfs(pow - 1)代表999以内和1999以内低三位1出现的个数;
            // (3) dfs(last)同上。
            return pow + high * dfs(pow - 1) + dfs(last);
        }
    }


    public int countDigitOne(int n) {
        //求每个位的数字所用
        int index = 1;
        //记录1的个数
        int count = 0;
        int high = n,cur = 0,low = 0;
        //由于high = n /(index*10) 中index *10 很容易越位
        //特修改如下
        while(high > 0){
            high /= 10;
            cur = (n / index) % 10;
            low = n - (n / index) * index;
            //以下是计算的公式
            if(cur == 0) count += high * index;
            if(cur == 1) count += high * index + low + 1;
            if(cur > 1) count += (high+1) * index;
            index *= 10;
        }
        return count;
    }
    @Test
    public void should_3(){
        int i = countDigitOne(501);
        System.out.println(i);
//        System.out.println(dfs(33));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        String nStr = String.valueOf(n);
        int high = nStr.charAt(0)- '0';
        int pow = (int)Math.pow(10, nStr.length() - 1);
        int last = n-high*pow;
        if (high==1){
            
            return NumberOf1Between1AndN_Solution(pow-1)+last+1+NumberOf1Between1AndN_Solution(last);
            
        }else{
            return pow+NumberOf1Between1AndN_Solution(last)+high*NumberOf1Between1AndN_Solution(pow-1);
        }
    }
}
