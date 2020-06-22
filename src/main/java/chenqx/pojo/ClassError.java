package chenqx.pojo;

import com.bytedance.cg.gcrm.common.util.DateUtil;
import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-06-04 10:19
 **/
public class ClassError {
    private String name;
    final static List<String> children = Lists.newArrayList();

    public ClassError(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        try {
            throw new RuntimeException("1234");
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getSuppressed());
        }
    }
    public static Object noModelReadByRows() throws IOException {
        return String.valueOf(new Date());
    }
}
