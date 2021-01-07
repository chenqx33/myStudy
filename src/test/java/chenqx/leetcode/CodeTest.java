package chenqx.leetcode;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author chenqx 2020-02-25
 * @instruction
 */
public class CodeTest {
    @Test
    public void should_code1() {
        System.out.println(sum1(100));
    }

    public int sum(int n) {
        if (n == 1) return n;
        return n + sum(n - 1);

    }

    public int sum1(int n) {
        int result=1;
        boolean b = n != 1 && ((result = n + sum(n - 1))==n);
        return result;

    }

    int substract(int num1, int num2) {
        int subtractor = add(~num2, 1);// 先求被减数的补码（取反加一）
        int result = add(num1, subtractor); // add()即上述加法运算　　
        return result;
    }

    int add(int num1, int num2) {
        if (num2 == 0)
            return num1;
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return add(sum, carry);
    }

    int multiply(int a, int b) {
        int[] c = new int[32];
        for (int i = 0; b != 0; i++) {
            c[i] = b % 2 == 1 ? 1 : 0;
            b = b >> 1;
        }
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 1)
                sum += a << i;
        }
        return sum;
    }

    public int Sum_Solution(int n) {
        int result = 0;
        int a = 1;
        boolean value = ((n != 0) && a == (result = Sum_Solution(n - 1)));
        result += n;
        return result;
    }


    public static void main(String[] args) {
        //去重
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {
            System.out.println(scanner.nextLine().replaceAll("(.)\\1+", "$1$1").replaceAll("(.)\\1(.)\\2", "$1$1$2"));
        }
    }
}
