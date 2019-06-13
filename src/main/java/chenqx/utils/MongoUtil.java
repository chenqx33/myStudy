package chenqx.utils;

public class MongoUtil {
    public static void main(String[] args) {

        int increment=1;
        int sum=0;
        for (int i = 0; i < 10; i++) {
            System.out.println(sum+ increment++);
        }


        System.out.println(getDataCollection("74745"));
    }
    public static String getDataCollection(String corpId) {
        return "fs_paas_auditlog_" + Math.abs(corpId.hashCode() % 100);
    }
}
