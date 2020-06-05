package chenqx.groovy


import spock.lang.Specification

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

    def "test1"() {
        when:
        println arg
        then:
        1==1
        where:
        arg   | _
        "123" | _
    }


}
