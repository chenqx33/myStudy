package chenqx.effectivejava.chapter3.item10;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private volatile int value;
    @Test
    public void main() {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger.get());
        System.out.println(value);
    }
}
