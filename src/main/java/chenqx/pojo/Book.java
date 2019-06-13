package chenqx.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.InetAddress;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Builder.Default
    private String auth="1";
    private String name="2";




    public static void main(String[] args) {

        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            String canonicalHostName = ia.getCanonicalHostName();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
            System.out.println("canonicalHostName ："+canonicalHostName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
