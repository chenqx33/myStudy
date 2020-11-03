package chenqx.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则判断
 */
public class StringUtil {
    public static String getMatcher(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }


    public static void main(String[] args) {
//        String url = "http://172.12.1.123/test.txt";
////        String url = "123.txt";
//        String regex = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})";
////        String regex = "";
//        System.out.println(getMatcher(regex,url));
//
////        System.out.println("123.txt".substring("123.txt".lastIndexOf('.') + 1));
////
////        JSON.parseArray("[{\"name\":\"1\"},{\"name\":\"1\"}{\"name\":\"1\"}]", Book.class);
////        System.out.println("11");

//        System.out.println(Pattern.matches("\\d+","123"));

        String s="CREATE TABLE `tenant_operator` (\n" +
                "  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',\n" +
                "  `name` varchar(128) NOT NULL DEFAULT '' COMMENT 'name',\n" +
                "  `description` varchar(256) NOT NULL DEFAULT '' COMMENT '描述',\n" +
                "  `symbol` varchar(255) NOT NULL DEFAULT '' COMMENT '符号',\n" +
                "  `customized` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否是自定义的操作符',\n" +
                "  `label` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `label_i18n` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `creator_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人ID',\n" +
                "  `creator_name` varchar(64) NOT NULL DEFAULT '' COMMENT '创建者名称',\n" +
                "  `modify_id` bigint NOT NULL DEFAULT '0' COMMENT '修改人ID',\n" +
                "  `modify_name` varchar(64) NOT NULL DEFAULT '' COMMENT '修改者名称',\n" +
                "  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',\n" +
                "  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录修改时间',\n" +
                "  `is_function` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否是函数',\n" +
                "  `group_name` varchar(128) NOT NULL DEFAULT '' COMMENT '操作符分组名称',\n" +
                "  `function_param_names` varchar(1024) NOT NULL DEFAULT '' COMMENT '函数参数列表, 是一个数组[]',\n" +
                "  `function_param_data_types` varchar(1024) NOT NULL DEFAULT '' COMMENT '函数参数类型列表, 是一个数组[]',\n" +
                "  `function_param_is_multiples` varchar(1024) NOT NULL DEFAULT '' COMMENT '函数参数是否是多值，是一个数组[]',\n" +
                "  `function_param_descriptions` varchar(1024) NOT NULL COMMENT '函数参数描述信息列表, 是一个数组[]',\n" +
                "  `function_param_examples` varchar(1024) NOT NULL DEFAULT '' COMMENT '函数参数示例，是一个数组[]',\n" +
                "  `operator_apply_scenes` varchar(1024) NOT NULL DEFAULT '' COMMENT '应用场景，是一个数组[]',\n" +
                "  `example` varchar(1024) NOT NULL DEFAULT '' COMMENT '函数使用示例',\n" +
                "  `return_description` varchar(1024) NOT NULL DEFAULT '' COMMENT '返回值描述信息',\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE KEY `uniq_name` (`name`) USING BTREE,\n" +
                "  KEY `idx_modify_time` (`modify_time`),\n" +
                "  KEY `uniq_symbol` (`symbol`(191)) USING BTREE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作符';";
        System.out.println(uniqueKey(s));
    }

//    public static void main(String[] args) throws Exception {
//        File file = new File("C:\\Users\\haogrgr\\Desktop\\你的sql文件");
//        String content = Files.toString(file, Charsets.UTF_8);
//
//        content = "SET MODE MYSQL;\n\n" + content;
//
//        content = content.replaceAll("`", "");
//        content = content.replaceAll("COLLATE.*(?=D)", "");
//        content = content.replaceAll("COMMENT.*'(?=,)", "");
//        content = content.replaceAll("\\).*ENGINE.*(?=;)", ")");
//        content = content.replaceAll("DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", " AS CURRENT_TIMESTAMP");
//
//        content = uniqueKey(content);
//
//        System.out.println(content);
//    }

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
