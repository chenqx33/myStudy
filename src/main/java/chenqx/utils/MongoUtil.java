package chenqx.utils;

public class MongoUtil {
    public static void main(String[] args) {



        System.out.println(getDataCollection("74745"));
    }
    public static String getDataCollection(String corpId) {
        return "fs_paas_auditlog_" + Math.abs(corpId.hashCode() % 100);
    }
}
