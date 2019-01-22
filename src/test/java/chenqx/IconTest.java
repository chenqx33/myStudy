package chenqx;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * @author cqx
 * @date 2018/12/20 10:46
 */
public class IconTest {
    private static IconTest iconTest = new IconTest();
    public static void main(String[] args) throws Exception {

        switch ("1"){
            case "1":{
                System.out.println("22");

            }
            case "2":{
                System.out.println(3);
            }
        }

        List<String> t = Lists.newArrayList("1","2","3");
        String folderPath = "C:\\Users\\nigul\\Desktop\\商品规格规格值1";
        File file = new File(folderPath);
        String ea = "";
        try {
            for (String f : file.list()) {
                String path = folderPath + "\\" + f;
                InputStream in = new FileInputStream(path);
                byte[] data = toByteArray(in);
//            String imagePath = gdsService.uploadFile(data, ea, userInfo, "png");
//            tmp.put(f.getName(), imagePath);
            }
        }catch (Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println("d");
        }
    }
}
