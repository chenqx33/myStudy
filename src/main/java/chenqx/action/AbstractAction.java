package chenqx.action;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-06-22 16:32
 **/
public abstract class AbstractAction implements Action{
    @Override
    public void act() {
        try {
            doAct();
        }catch (Exception e){
            System.out.println("catch:"+e.getMessage());
        }
    }

    public void doAct(){
        System.out.println(123);
    }
}
