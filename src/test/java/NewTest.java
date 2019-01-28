import org.junit.Test;

public class NewTest {

    /**
     * String.format中用百分号转义百分号
     */
    @Test
    public void format1(){
        String s ="hello{} world{%%%s},%s";
        System.out.println(String.format(s, "1","2"));
    }
}
