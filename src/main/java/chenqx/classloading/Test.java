package chenqx.classloading;

/**
 * @author chenqx 2020-01-07
 * @instruction
 * 初始化顺序 1、父类_静态变量->父类_静态代码块->子类_静态变量->子类_静态变量
 *          2.父类_普通变量->父类_构造代码块->父类_构造函数->子类_普通变量->子类_构造代码块->子类_构造函数
 *
 */
public class Test {
    public static void main(String[] args) {
        new ChildClass();
        new ChildClass();
    }
}
