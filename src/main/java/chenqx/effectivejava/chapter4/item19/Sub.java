package chenqx.effectivejava.chapter4.item19;

import java.time.Instant;

public class Sub extends Super {
    private final Instant instant;
    Sub(){
        instant = Instant.now();
    }

    @Override
    protected void overrideMe() {
        //
        instant.hashCode();
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
