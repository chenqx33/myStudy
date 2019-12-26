package chenqx.aopTest;

public class BarServiceImp implements BarService{
    public String doSomething(String s,int a ) {
        System.out.println("执行原有逻辑");
//        if (true) throw new RuntimeException("1");
        String ss = "";
        return s+"1";
    }
}
