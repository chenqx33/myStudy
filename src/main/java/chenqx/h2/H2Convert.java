package chenqx.h2;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-12-01 13:57
 **/
public class H2Convert {
    public static void main(String[] args) throws Exception {
        File file = new File(H2Convert.class.getClassLoader().getResource("mysql").getPath());
        String content = Files.toString(file, Charsets.UTF_8);

        content = "SET MODE MYSQL;\n\n" + content;

        content = content.replaceAll("comment.*'(?=,|\\n|;)", "");
        content = content.replaceAll("comment.*(?=;)", "");
        content = content.replaceAll("COLLATE.*(?=;)", "");
//        content = content.replaceAll("\\).*ENGINE.*(?=;)", ")");
        content = content.replaceAll("on update CURRENT_TIMESTAMP", "CURRENT_TIMESTAMP");
        content = content.replaceAll("b'", "'");

        content = uniqueKey(content);

        System.out.println(content);
    }

    /**
     * h2的索引名必须全局唯一
     *
     * @param content sql建表脚本
     * @return 替换索引名为全局唯一
     */
    private static String uniqueKey(String content) {
        int inc = 0;
        Pattern pattern = Pattern.compile("(?<=KEY )(.*?)(?= \\()");
        Matcher matcher = pattern.matcher(content);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group() + inc++);
        }
        matcher.appendTail(sb);
        content = sb.toString();
        return content;
    }
}
