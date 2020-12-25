package chenqx.pojo

/**
 *
 * @description:
 *
 * @version: 1.0* @author: chenqixin*
 * @create: 2020-11-26 20:55
 * */
class BookTest extends spock.lang.Specification {
    def "Service"() {
        when:
        new Book().service()
        then:
        noExceptionThrown()
    }
}
