package chenqx.old;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-04-28 11:56
 **/
public interface book1234 extends book123 {

    default String hello(){
        return "hi";
    }
}
