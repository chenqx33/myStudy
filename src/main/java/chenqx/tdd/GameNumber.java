package chenqx.tdd;

import static java.lang.String.valueOf;

/**
 * @author chenqx
 * @date 2019-08-13 18:43
 * @instruction
 */
public class GameNumber {
    private Integer number;

    public GameNumber(int i) {
        number = i;
    }

    @Override
    public String toString() {
        if (isRelated(3) && isRelated(5)) {
            return "fizzbuzz";
        }
        if (isRelated(3)) {
            return "fizz";
        }
        if (isRelated(5)) {
            return "buzz";
        }

        return valueOf(number);
    }

    private boolean isRelated(int i) {
        return number % i == 0 || valueOf(number).contains(valueOf(i));
    }
}
