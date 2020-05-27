package chenqx.groovy

import chenqx.pojo.MyUser
import chenqx.pojo.User
import jdk.nashorn.internal.objects.annotations.Where
import spock.lang.Specification;

/**
 * @author chenqx 2019-10-14
 * @instruction
 */
class Test extends Specification {
    private static String name

    def "setup"() {
        name = "start"
    }

    def "cleanup"() {
        name = "end"
    }

    def "test"() {
        when:
        println name
        then:
        1 == 1
        where:
        arg   | result
        "123" | "2"
    }

    def "test1"() {
        when:
        println name
        then:
        check()
        where:
        arg   | result | check
        "123" | "2"    | { noExceptionThrown() }
    }


}
