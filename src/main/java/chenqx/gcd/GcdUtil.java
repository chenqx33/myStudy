package chenqx.gcd;

import lombok.Data;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-10-14 21:17
 **/
public class GcdUtil {
    public static void main(String[] args) {
        System.out.println(gcd(24, 60));
        Integer xy = new Integer();
        gcdEx(24, 60, xy);
        System.out.println(xy);
    }

    /**
     * gcd(a,b) = gcd(b,a mod b) a>b
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);

    }

    public static int gcdEx(int a, int b, Integer xy) {
        if (b == 0) {
            xy.setX(1);
            xy.setY(0);
            return a;
        } else {
            int r = gcdEx(b, a % b, xy);
            /* r = GCD(a, b) = GCD(b, a%b) */
            int t = xy.getX();
            xy.setX(xy.getY());
            xy.setY( t - a / b * xy.getY());
            return r;
        }
    }
    @Data
    static
    class Integer{
        int x;
        int y;
    }
}
