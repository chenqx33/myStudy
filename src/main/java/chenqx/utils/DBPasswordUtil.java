package chenqx.utils;

/**
 * 数据库密码工具类
 * @author wangtao
 * @date 2015年8月31日 上午10:40:34
 */
public class DBPasswordUtil {

    /**
     * 密钥
     */
    private static final String KEPT = "fs68ky31vf33";

    /**
     * 解密密码
     * @param encryptPwd
     * @return
     */
    public static String decode(String encryptPwd) {
        return StrAES.decodeAES(encryptPwd, DBPasswordUtil.KEPT);
    }

    /**
     * 加密算法
     * @param encryptPwd
     * @return
     */
    public static String encode(String encryptPwd) {
        return StrAES.encodeAES(encryptPwd, DBPasswordUtil.KEPT);
    }

    public static void main(String[] args) {

        String encrtptPwd= DBPasswordUtil.encode("123");
        System.out.println(encrtptPwd);
        System.out.println(DBPasswordUtil.decode("F61861232224775EFE9DED240A73F2A52787CE0A47C7478589709FDFD348D83D"));
    }
}
