package chenqx.trytest;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Try;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-12-28 21:35
 **/
public class MyTry {
    public static void main(String[] args) {
        final Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        System.out.println(java8._1);
        System.out.println(java8._2);
        final Try<Void> run = Try.run(() -> System.out.println("123"));
        run.andThen(()-> System.out.println("321"));;;
    }
}
