package chenqx.newTest;

import chenqx.pojo.Obj;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

/**
 * @author chenqx
 * @date 2019-07-12 17:03
 * @instruction
 */
public class Test5 {
    @Test
    public void hh() {
        Matcher matcher = Pattern.compile("(-[a-z] [^-]*)").matcher("-p 1 -m 8080");
        while (matcher.find()) {
            System.out.println(matcher.group(1));

        }
    }

    @Test
    public void hhh() {
        Matcher matcher = Pattern.compile("(-[a-z] [^-]*)").matcher("-p 1 -m 8080");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(1));

        }
    }

    @Test
    public void should_double_equals() {
        RateLimiter rateLimiter = RateLimiter.create(0.00000001);

        int i=0;
        while (true){
            rateLimiter.acquire();
            System.out.println(++i);
        }
    }
    @Test
    public void should_getId(){
        List<Obj> list = Lists.newArrayList(
                new Obj("1","1"),
                new Obj("1","2"),
                new Obj("1","3"),
                new Obj("2","1"),
                new Obj("2","2"),
                new Obj("2","3"),
                new Obj("3","1"),
                new Obj("4","1"),
                new Obj("4","2"),
                new Obj("5","1"),
                new Obj("6",null)
        );

        Map<String, Stack<Obj>> collect = list.stream().collect(Collectors.groupingBy(Obj::getPkgId, toCollection(Stack::new)));
        List<List<Obj>> argList = Lists.newArrayList();

        while (true){
            List<Obj> args = Lists.newArrayList();
            collect.forEach((k,v)->{
                if (!v.isEmpty()){
                    args.add(v.pop());
                }
            });
            if (args.isEmpty()){
                break;
            }else {
                argList.add(args);
            }
        }
        System.out.println(argList);

    }

//
//    private List<Obj> getArgByRecursive(List<Obj> source, Set<String> un, Map< List<Obj>>){
//        if (isUnique(source)){
//            return source;
//        }
//
//    }

    private boolean isUnique(List<Obj> source){
        return source.stream().map(Obj::getPkgId).distinct().count()==source.size();
    }

    @Test
    public void should(){
        System.out.println(Sets.newHashSet("".split(",")));
        System.out.println(MessageFormat.format("{0},{0},{1}","1","2"));
        String s = null;
//        System.out.println(new BigDecimal(s));
//        System.out.println(new BigDecimal(null));
        System.out.println(new BigDecimal(""));
    }

}
