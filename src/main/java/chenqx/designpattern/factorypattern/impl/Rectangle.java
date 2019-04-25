package chenqx.designpattern.factorypattern.impl;

import chenqx.designpattern.factorypattern.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is rectangle");
    }
}
