package chenqx.designpattern.factorypattern;

import chenqx.designpattern.factorypattern.impl.Square;

/**
 * 工厂模式测试
 */
public class Test {
    public static void main(String[] args) {
        Square share = ShareFactory.getShare(Square.class);
        share.draw();


    }

}
