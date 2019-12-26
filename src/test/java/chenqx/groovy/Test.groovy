package chenqx.groovy

import chenqx.pojo.MyUser
import chenqx.pojo.User
import spock.lang.Specification;

/**
 * @author chenqx 2019-10-14
 * @instruction
 */
class Test extends Specification {
    User user = Mock(User)

    def "set_private"() {
        given:
        user.getName() >> "xiaolan"

        when:
        def name = user.getName()
        then:
        name == "xiaolan"
    }

    def "user"() {
        given:
//        User ss = new User();
//        ss.setName("12")
//        MyUser s = new MyUser("2","1")
        when:
        User ss = new User()
        ss.setName("12")
        MyUser s = new MyUser("2", "1")
        s.setName("2")
        then:
        ss.name == "12"
        s.name == "2"
        s.arg != null
    }




}
