package chenqx.tdd;


/**
 * @author chenqx
 * @date 2019-08-13 19:32
 * @instruction
 */
public class FizzBuzz {

    public static String of(int input) {
        String result = "";
        if (isRelated(input, 3, "3")) result += "fizz";
        if (isRelated(input, 5, "5")) result += "buzz";
        if (result.isEmpty()) result += input;
        return result;
    }

    private static boolean isRelated(int input, int i, String s) {
        return input % i == 0 || String.valueOf(input).contains(s);
    }
}
