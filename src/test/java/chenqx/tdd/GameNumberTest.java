package chenqx.tdd;


import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author chenqx
 * @date 2019-08-13 17:55
 * @instruction
 */
public class GameNumberTest {
    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource({
            "1,'1'",
            "3,'fizz'",
            "5,'buzz'",
            "15,'fizzbuzz'",
            "52,'buzz'",
            "53,'fizzbuzz'",
    })
    public void shouldNumber(int input, String worlds) {
        assertThat(FizzBuzz.of(input)).isEqualTo(worlds);

    }

    @Test
    public void should() {
        Maps.newConcurrentMap().put(null,"");
    }

}
