package chenqx.interfaces;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-11-02 14:16
 **/
public class Man implements People {
    @Override
    public double getHeight() {
        return 0;
    }

    public static void main(String[] args) {
//        Class<Man> manClass = Man.class;
//        Class<?>[] interfaces = manClass.getInterfaces();
//        System.out.println("1");
        String[] words = {"hello","world"};
        List<String> collect = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());


    }
}
