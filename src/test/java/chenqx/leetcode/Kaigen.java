package chenqx.leetcode;

import org.junit.Test;

/**
 * @author chenqx 2020-02-29
 * @instruction
 */
public class Kaigen {
    @Test
    public void should_1() {

    }

//    public float SquareRootFloat(float number) {
//    long i;
//    float x, y;
//    const float f = 1.5F;
//    x = number * 0.5F; y = number;
//    i = * ( long * ) &y;
//    i = 0×5f3759df - ( i >> 1 ); //注意这一行 y = * ( float * ) &i; y = y* ( f – ( x * y * y ) );
//    y = y * ( f - ( x * y * y ) );
//    return number * y;
//    }

//    public String s(float number) {
//        long i;
//    float x, y;
//    float f = 1.5F;
//    x = number * 0.5F; y = number;
//    i = * ( long * ) &y;
//    i = 0×5f 3759d f - ( i >> 1 ); //注意这一行 y = * ( float * ) &i; y = y* ( f – ( x * y * y ) );
//    y = y * ( f - ( x * y * y ) );
//    return number * y;
//    }
    //https://blog.csdn.net/yzy_csdn/article/details/98519426?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
    public static double sqrt (double c) {

        if (c < 0) return Double.NaN;

        double err = 1e-15;

        double t = c;

        while( Math.abs(t - c/t) > err * t)

            t = (c/t + t) /2.0;

     return t;
    }
    @Test
    public void should_2(){
        System.out.println(sqrt(4));
    }
}
