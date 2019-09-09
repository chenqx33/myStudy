package chenqx.newTest;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * @author chenqx
 * @date 2019-07-12
 * @instruction
 */
public class Test3 {
    @Test
    public void ss() throws IllegalAccessException, InstantiationException {


        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(today_start.toInstant(ZoneOffset.of("+8")).toEpochMilli());

        StringBuilder stringBuilder = new StringBuilder("123");
        System.out.println(stringBuilder.substring(1));
        System.out.println(StringEscapeUtils.escapeSql("'B'"));
    }
}
