package chenqx.old;

/**
 * @author cqx
 * @date 2019/1/10 19:27
 */
public class JitTest {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int n = 0;
        for (int i = 0; i < 1000000000; i++) {
            n += 2 * i * i;
        }
        System.out.println((double) (System.nanoTime() - startTime) / 1000000000 + " s");
        System.out.println("n = " + n);

        startTime = System.nanoTime();
        n = 0;
        for (int i = 0; i < 1000000000; i++) {
            n += 2 * (i * i);
        }
        System.out.println((double) (System.nanoTime() - startTime) / 1000000000 + " s");
        System.out.println("n = " + n);
    }
}
