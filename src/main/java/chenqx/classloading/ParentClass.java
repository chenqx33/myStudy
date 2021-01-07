package chenqx.classloading;

/**
 * @author chenqx 2020-01-07
 * @instruction
 */
public class ParentClass {
//    private static String name = name();
//    private String auth = auth();
    static {
        System.out.println("parent static");
    }
//    {
//        System.out.println("parent ");
//    }
//
//    public ParentClass() {
//        System.out.println("parent constructor");
//    }
//    private static String name(){
//        System.out.println("parent name");
//        return "parent name";
//    }
//    private String auth(){
//        System.out.println("parent auth");
//        return "parent auth";
//    }
}
