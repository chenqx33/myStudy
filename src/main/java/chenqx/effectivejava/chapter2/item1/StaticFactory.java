package chenqx.effectivejava.chapter2.item1;

import chenqx.old.SeasonEnum;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

import static chenqx.old.SeasonEnum.*;

/**
 * path：https://github.com/chenqx33/Effective-Java-3rd-edition-Chinese-English-bilingual/blob/dev/Chapter-2/Chapter-2-Item-1-Consider-static-factory-methods-instead-of-constructors.md
 *
 * 静态工厂方法与构造函数相比。
 * 优点：
 *  1.静态工厂方法有确切的名字。
 *  2.静态工厂方法不需要在每次调用时创建新对象 例如：Boolean.valueOf(boolean);
 *  3.可以通过静态工厂方法获取返回类型的任何子类的对象。
 *  4.返回对象的类可以随调用的不同而变化，作为输入参数的函数。
 *  5.当编写包含方法的类时，返回对象的类不需要存在。
 *
 * 缺点：
 *  1.没有公共或受保护构造函数的类不能被子类化。
 *  2.程序员很难找到他们。
 */
public class StaticFactory {
    //from，一种类型转换方法，该方法接收单个参数并返回该类型的相应实例
    Date d = Date.from(Instant.now());

    //of，一个聚合方法，他接受多个参数并返回一个包含这些参数的此类的实例
    Set<SeasonEnum> faceCards = EnumSet.of(SPRING,SUMMER,AUTUMN,WINTER);

    //valueOf，一种替代from和of但工冗长的方法
    BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);


}
