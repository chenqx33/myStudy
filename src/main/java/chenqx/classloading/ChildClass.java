package chenqx.classloading;

/**
 * @author chenqx 2020-01-07
 * @instruction
 */
public class ChildClass extends ParentClass {
//    private static String name = name();
//    private String auth = auth();
    static {
        System.out.println("child static");
    }
//    {
//        System.out.println("child ");
//    }
//
//    public ChildClass() {
//        System.out.println("child constructor");
//    }
//
//    private static String name(){
//        System.out.println("child name");
//        return "child name";
//    }
//    private String auth(){
//        System.out.println("child auth");
//        return "child auth";
//    }
}

