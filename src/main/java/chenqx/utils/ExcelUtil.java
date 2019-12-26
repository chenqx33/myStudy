package chenqx.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;

/**
 * @author chenqx 2019-10-21
 * @instruction
 */
public class ExcelUtil {
    public static void main(String[] args) {
        String resource = ExcelUtil.class.getClassLoader().getResource("excel/物料(规格规格值导入).xls").getPath();
        try {
            read(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void read(String fileName) throws Exception {
        if (fileName == null) return;

        File xlsFile = new File(fileName);
        if (!xlsFile.exists()) return;

        // 工作表
        Workbook workbook = WorkbookFactory.create(xlsFile);
        // 表个数
        int numberOfSheets = workbook.getNumberOfSheets();
//      System.out.println(numberOfSheets);
        if (numberOfSheets <= 0) return;

        //我们的需求只需要处理一个表，因此不需要遍历
        Sheet sheet = workbook.getSheetAt(0);
        // 行数
        int rowNumbers = sheet.getLastRowNum() + 1;
//      System.out.println(rowNumbers);
        // 读数据，第二行开始读取
        for (int row = 1; row < rowNumbers; row++) {
            Row r = sheet.getRow(row);
            //我们只需要前两列
            if (r.getPhysicalNumberOfCells() >= 2) {
//                score = new StudentScore(r.getCell(0).toString(), (int) Double.parseDouble(r.getCell(1).toString()));
                System.out.println("");
            }
        }
    }
}
