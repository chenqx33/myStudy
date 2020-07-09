package chenqx.action;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-06-22 16:34
 **/
public class StandardAction extends AbstractAction {
    @Override
    public void doAct() {
        super.doAct();
        throw new RuntimeException("hh");
    }

    public static void main(String[] args) {
        StandardAction action = new StandardAction();
        action.act();
    }
}
