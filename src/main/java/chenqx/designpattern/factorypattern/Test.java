package chenqx.designpattern.factorypattern;

public class Test {
    public static void main(String[] args) {
//        Square share = ShareFactory.getShare(Square.class);
//        share.draw();
//
//        List<String> list = Lists.newArrayList();
//        list.stream().findFirst().get();
        System.out.println(recursive(100));

    }

    static int recursive(int i){
        if (i==1) return i;
        return recursive(i-1)+i;
    }
}
