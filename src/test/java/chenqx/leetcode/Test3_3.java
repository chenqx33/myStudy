package chenqx.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenqx 2020-03-03
 * @instruction
 */
public class Test3_3 {
    @Test
    public void should_1() {
        System.out.println(PrintMinNumber(new int[]{3, 32, 321}));
        System.out.println(PrintMinNumber(new int[]{10, 2}));
    }

    //{3，32，321}
    public String PrintMinNumber(int[] numbers) {
        List<Integer> helper = new ArrayList<>();
        for (int number : numbers) {
            helper.add(number);
        }

        String result = helper.stream().sorted(this::comparator)
                .map(String::valueOf).collect(Collectors.joining());

        return result;
    }

    private int comparator(Integer o1, Integer o2) {
        if (o1.equals(o2)) return 0;
        if (o1.toString().startsWith(o2.toString())) {
            String s = o1.toString().replaceAll(o2.toString(), "");
            if (s.equals("")) return 0;
            int fu;
            for (int i = 0; i < o2.toString().length(); i++) {
                fu = s.charAt(0) - '0' - (o2.toString().charAt(i) - '0');
                if (fu != 0) return fu;
            }
        }
        if (o2.toString().startsWith(o1.toString())) {
            String s = o2.toString().replaceAll(o1.toString(), "");
            int fu;
            if (s.equals("")) return 0;
            for (int i = 0; i < o1.toString().length(); i++) {
                fu = (o1.toString().charAt(i) - '0') - (s.charAt(0) - '0');
                if (fu != 0) return fu;
            }

        }
        int o1High = o1 / ((int) Math.pow(10, o1.toString().length() - 1));
        int o2High = o2 / ((int) Math.pow(10, o2.toString().length() - 1));
        if (o1High > o2High) return 1;
        if (o1High < o2High) return -1;
        if (o1.toString().length() == 1) {
            return o1 - (Integer.valueOf(o2.toString().charAt(1) - '0'));
        }
        if (o2.toString().length() == 1) {
            return (Integer.valueOf(o1.toString().charAt(1) - '0')) - o2;
        }
        if (Integer.valueOf(o1.toString().charAt(1) - '0') == 0 ^ Integer.valueOf(o2.toString().charAt(1) - '0') == 0) {
            if (Integer.valueOf(o1.toString().charAt(1) - '0') == 0) return -1;
            return 1;
        }

        o1 %= (int) Math.pow(10, o1.toString().length() - 1);
        o2 %= (int) Math.pow(10, o2.toString().length() - 1);
        return comparator(o1, o2);
    }


    @Test
    public void should_2() {
        PrintMinNumber1(new int[]{121, 12, 30, 3, 11});

    }

    public String PrintMinNumber1(int[] numbers) {
        List<String> helper = new ArrayList<>();
        for (int number : numbers) {
            helper.add(String.valueOf(number));
        }
        helper.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        System.out.println(helper);
        return String.join("", helper);
    }

    @Test
    public void should_4() {
        System.out.println("1".compareTo("2"));
    }

    @Test
    public void should_5() {

    }

    private int chou(int k){
        boolean b=false;
        for (int i = 0, sum = 1; ; i++) {
            if (i % 2 == 0) b = true;
            if (i % 3 == 0) b = true;
            if (i % 5 == 0) b = true;
            if (i % 15 == 0) b = true;
            if (i % 6 == 0) b = true;
            if (b)sum++;
            if (sum==k)return i;

            b=false;

        }
    }
    public boolean isUgly(int num) {
        int temp;
        while (num!=1){
            temp=num;
            num=num%2==0?num/2:num;
            num=num%3==0?num/3:num;
            num=num%5==0?num/5:num;
            if (temp==num){
                return false;
            }
        }
        return true;

    }
    @Test
    public void should_7(){
        System.out.println(isUgly(18));
        new Ugly();
    }
    class Ugly {
        public int[] nums = new int[1690];
        Ugly() {
            HashSet<Long> seen = new HashSet();
            PriorityQueue<Long> heap = new PriorityQueue<Long>();
            seen.add(1L);
            heap.add(1L);

            long currUgly, newUgly;
            int[] primes = new int[]{2, 3, 5};
            for(int i = 0; i < 1690; ++i) {
                currUgly = heap.poll();
                nums[i] = (int)currUgly;
                for(int j : primes) {
                    newUgly = currUgly * j;
                    if (!seen.contains(newUgly)) {
                        seen.add(newUgly);
                        heap.add(newUgly);
                    }
                }
            }
        }
    }
    //优先队列
    @Test
    public void should_6(){
        Comparator<Long> comparator = (o1,o2)->(int)(o2-o1);
        PriorityQueue<Long> heap = new PriorityQueue<Long>(comparator){};
        heap.add(1L);
        heap.add(3L);
        heap.add(2L);
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}
