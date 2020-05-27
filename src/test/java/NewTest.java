import chenqx.old.SeasonEnum;
import chenqx.pojo.Book;
import chenqx.pojo.Child3;
import chenqx.pojo.Parent3;
import chenqx.search.impl.Child;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.cg.gcrm.common.util.DateUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.springframework.data.redis.core.TimeoutUtils;
import sun.security.action.GetPropertyAction;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.AccessController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NewTest {
    private String json = "{\"discount\":\"100\",\"pricebook_sellingprice\":\"3\",\"product_id\":\"5d8c6ffd665f2e000186006e\",\"record_type\":\"default__c\",\"object_describe_api_name\":\"PriceBookProductObj\",\"object_describe_id\":\"5da1425cb2939e000177fdaa\",\"tenant_id\":\"675804\",\"owner\":[\"1000\"],\"field_finance__c\":123}";
    private JSONObject nameToId;
    private JSONObject pricenameToId;

    public NewTest() throws IOException {
        String nameToIdStr = IOUtils.toString(getClass().getClassLoader().getResource("nametoid.json"), "UTF-8");
        nameToId = JSON.parseObject(nameToIdStr);
        String pricenameToIdStr = IOUtils.toString(getClass().getClassLoader().getResource("pricebooknametoid.json"), "UTF-8");
        pricenameToId = JSON.parseObject(pricenameToIdStr);

    }

    @Test
    public void ss() {
        try {
            read("/Users/chenqx/Downloads/临时/价目表数据10.29.xlsx");
        } catch (Exception e) {
        }
    }

    Map<Object, JSONObject> read(String fileName) throws Exception {
        List<JSONObject> result = Lists.newArrayList();
        if (fileName == null) return null;

        File xlsFile = new File(fileName);
        if (!xlsFile.exists()) return null;

        Workbook workbook = WorkbookFactory.create(xlsFile);
        //我们的需求只需要处理一个表，因此不需要遍历
        Sheet sheet = workbook.getSheetAt(0);
        // 行数
        int rowNumbers = sheet.getLastRowNum() + 1;

        for (int row = 1; row < rowNumbers; row++) {
            Row r = sheet.getRow(row);
            if (!r.getCell(1).toString().equals("财务价目表")) continue;
            //价目表ID对应销售价目表ID，基价价目表ID对应财务价目表ID
            String productName = r.getCell(6).toString().trim();
            String salesPrice = r.getCell(14).toString().trim();   //销售报价           pricebook_sellingprice
            String salesPriceBookId = r.getCell(8).toString().trim();  //销售价目表id   field_price_list__c
            String pricebookType = r.getCell(2).toString().trim();

            if (pricebookType.equals("1571.0")) {
                salesPriceBookId = salesPriceBookId.substring(0, salesPriceBookId.indexOf("."));

                JSONObject jsonObject = JSON.parseObject(json);
                Object productId = nameToId.get(productName);
                if (productId == null) {
                    System.out.println(productName);
                } else {
                    jsonObject.put("product_id", productId);
                    jsonObject.put("pricebook_sellingprice", salesPrice);
                    jsonObject.put("field_finance__c", salesPrice);
                    jsonObject.put("field_baseprice__c", salesPriceBookId);
//                    jsonObject.put("name", UUID.randomUUID());
                    result.add(jsonObject);
                }
            }
        }
        Map<Object, JSONObject> result1 = result.stream().collect(Collectors.toMap(o -> o.get("product_id"), o -> o));
        System.out.println(result.size());
        return result1;
    }


    @Test
    public void should_stream() {
        ArrayList<String> productIds = Lists.newArrayList("5d4955a0bc800c00010ee7ea", "5d41374cd86e34000112632c", "5d7a120e19166f00016dc861", "5d7a120e19166f00016dc862", "5d7a120e19166f00016dc863", "5d89be324363912b13cf954d", "5d89be324363912b13cf954c", "5d8c6f72665f2e000185f7ec", "5d8c6ffd665f2e000186006e", "5d479943bc800c00010dddaf", "5d5775d93a13180001aef407", "5d6660562465230001c786dd", "5d40fb922e73900001a41ea7", "5d40fb922e73900001a41ea5", "5d40fb922e73900001a41ea6", "5d413835d86e340001126a52", "5d4135e4d86e340001125bd8", "5d4142aff57194000160986a", "5d414590f57194000160a687", "5d414301f571940001609cfa", "5d414342f571940001609ea5", "5d414375f57194000160a10e", "5d414357f571940001609fd4", "5d4166c78fafcc0001ceb315", "5d4165b88fafcc0001ceaf07", "5d4179933d21350001180eba", "5d417a713d2135000118102f", "5d4183dd3d213500011832b5", "5d41848b3d21350001183a10", "5d42868bbc800c00010c288c", "5d4184bb3d21350001183c20", "5d4290cabc800c00010c3355", "5d417cf43d21350001181a0b", "5d429261bc800c00010c3d9c", "5d429261bc800c00010c3d9d", "5d41800b3d21350001181de1", "5d42a363bc800c00010c9af2", "5d42d65fbc800c00010cf4ec", "5d4a729fbc800c00010f3c90", "5d42d788bc800c00010d0293", "5d4ab1239925b70001c9f674", "5d4aa61c9925b70001c9d13c", "5d495553bc800c00010ee5d8", "5d4955a0bc800c00010ee7e9", "5d4b879d98e9840001e29ea2", "5bee3a54a5083d3630233474", "5c0b901aa5083dbf20cfa77e", "5c0b901aa5083dbf20cfa760", "5bebefb2a5083db6b76a8057", "5cfe1bc63bb3ae0001d822fd", "5bebefb2a5083db6b76a8058", "5bebefb2a5083db6b76a805a", "5c0b901aa5083dbf20cfa7a5", "5bebefb2a5083db6b76a8059", "5bebefb2a5083db6b76a8056", "5c0b901aa5083dbf20cfa7be", "5c10d75ba5083dd643b2d94e", "5bebe7eda5083daa02dbfd23", "5c0f6d2ea5083d953cd68069", "5c0b901aa5083dbf20cfa75c", "5c0b901aa5083dbf20cfa764", "5c0b901aa5083dbf20cfa7b0", "5c0b901aa5083dbf20cfa7a7", "5c0b901aa5083dbf20cfa786", "5bebcadfa5083d793fa46c89", "5c886b648fccf23eb8072ac2", "5c349e9aa5083d4def779e6f", "5c3559eaa5083d4defb2e636", "5c349ab5a5083d4def6a2e88", "5d5124183a13180001a6f6a9", "5d5124183a13180001a6f6aa", "5d5124183a13180001a6f6ab", "5d5124183a13180001a6f6ac", "5d5124183a13180001a6f6ad", "5d5124183a13180001a6f6ae", "5d5124183a13180001a6f6af", "5d5124183a13180001a6f6b0", "5d5124183a13180001a6f6b1", "5d5124183a13180001a6f6b2", "5d5124183a13180001a6f6b3", "5c349cbba5083d4def7008d7", "5c349f1aa5083d4def79065f", "5d479943bc800c00010dddb0", "5d1d77397cfed90fb26bf641", "5c09ed4fa5083d64f509b5d1", "5c349d37a5083d4def71e946", "5c36fee0a5083d427d8c2c33", "5c349e1da5083d4def75f8b7", "5c3565f2a5083d4defb8cafa", "5c349f24a5083d4def792a8f", "5c349f30a5083d4def795223", "5c3499a6a5083d4def67c224", "5c349d27a5083d4def71ad36", "5c0b901aa5083dbf20cfa7b4", "5c0b901aa5083dbf20cfa7ac", "5c0b901aa5083dbf20cfa7bf", "5c0b901aa5083dbf20cfa7c1", "5c0b901aa5083dbf20cfa7c7", "5c10d78fa5083dd643b2f013", "5c2f0beba5083dace4b3e77a", "5c2f0beba5083dace4b3e770", "5c2f0beba5083dace4b3e67e", "5c2f0beba5083dace4b3e70e", "5c359782a5083d1e81d8f9f9", "5c134cd203f80581a0a0c091", "5c359782a5083d1e81d8f9f3", "5c2f0beba5083dace4b3e6c4", "5c36fedda5083d427d8c2464", "5c2f0beba5083dace4b3e6b0", "5c36fed6a5083d427d8c074c", "5c349e5ba5083d4def76cb6e", "5c3566a9a5083d4defb9a28b", "5bff983ca5083dc171520fc8", "5c2f0beba5083dace4b3e76c", "5c359782a5083d1e81d8f9b1", "5c146d8f03f805d728b423fd", "5c2f0beba5083dace4b3e77e", "5c359782a5083d1e81d8f987", "5c2f0beba5083dace4b3e69c", "5c2f0beba5083dace4b3e712", "5c2f0beba5083dace4b3e72c", "5c2f0beba5083dace4b3e686", "5c359782a5083d1e81d8f9f5", "5c359782a5083d1e81d8f9d3", "5c13639703f805378cee2bdd", "5c349cf9a5083d4def70ff15", "5c13524d03f8052de06ddb9f", "5c278f61a5083df69150c632", "5c359782a5083d1e81d8f97f", "5c2f0beba5083dace4b3e730", "5c2f0beba5083dace4b3e6bc", "5c2f0beba5083dace4b3e6d2", "5c2f0beba5083dace4b3e6ac", "5c2f0beba5083dace4b3e792", "5bff98b6a5083dc17152221d", "5c2f0beba5083dace4b3e67a", "5d53de9e3a13180001a9aa2c", "5c1463f1a5083d2694c54464", "5c359782a5083d1e81d8f9d9", "5c356581a5083d4defb7f700", "5c2f0beba5083dace4b3e734", "5d53de9e3a13180001a9aa2b", "5c2f0beba5083dace4b3e6d6", "5c36fd3ea5083d427d8af5d2", "5c2f0beba5083dace4b3e6b4", "5c349e7fa5083d4def7742d6", "5c349e29a5083d4def76241c", "5c36fee6a5083d427d8c3eda", "5c278f61a5083df69150c62a", "5c349e9aa5083d4def779c2c", "5c359782a5083d1e81d8f9d7", "5c1355fea5083dba4cd4e85e", "5c359782a5083d1e81d8f9cf", "5c2f0beba5083dace4b3e738", "5c359782a5083d1e81d8f9cd", "5c0b901aa5083dbf20cfa7bd", "5c349cffa5083d4def7113ac", "5c349e2aa5083d4def7628a2", "5c3565f6a5083d4defb8d7ea", "5c349cf4a5083d4def70e934", "5c349ecca5083d4def783981", "5c349e16a5083d4def75e097", "5c349d5ea5083d4def728518", "5c3566b7a5083d4defb9da81", "5c349fc5a5083d4def7b406c", "5c349d03a5083d4def712442", "5c349d04a5083d4def712685", "5c349991a5083d4def678ed4", "5c349d54a5083d4def725f66", "5c349d1fa5083d4def718f96", "5c349e1aa5083d4def75efab", "5c349e67a5083d4def76f6c1", "5c3499e8a5083d4def6863ed", "5c3565fba5083d4defb8e707", "5c349d50a5083d4def724ca6", "5c349d25a5083d4def71a5ac", "5c349f2ea5083d4def794c1b", "5c349f92a5083d4def7a8926", "5c3499d5a5083d4def6834e7", "5c34a07fa5083d4def7dd833", "5c349f2aa5083d4def793fb6", "5c36fd41a5083d427d8afcf7", "5c34a006a5083d4def7c2f66", "5c349979a5083d4def675587", "5c3565a4a5083d4defb83483", "5c349fe2a5083d4def7ba986", "5c3499f4a5083d4def6882ed", "5c3565f1a5083d4defb8c735", "5c349effa5083d4def78b5ec", "5c349cf0a5083d4def70da20", "5c349e72a5083d4def7719ba", "5c349fa5a5083d4def7ac861", "5c3565a7a5083d4defb83e7b", "5c349d14a5083d4def7161e0", "5c3565fba5083d4defb8e646", "5c349f24a5083d4def7929ce", "5c349cf8a5083d4def70f9ce", "5c36fecba5083d427d8be95c", "5c349d75a5083d4def72de9f", "5c349f25a5083d4def792f15", "5c349d25a5083d4def71a66d", "5c349cc5a5083d4def7030c5", "5c0b901aa5083dbf20cfa762", "5c0b901aa5083dbf20cfa7cc", "5c349a13a5083d4def68cd1c", "5c349b19a5083d4def6b9fab", "5c35b8cfa5083d32762bbbaa", "5c349d4ea5083d4def72445b", "5c349d10a5083d4def71538d", "5c36fd39a5083d427d8ae985", "5c36fecda5083d427d8bf00b", "5c349d19a5083d4def7178e1", "5c349cf2a5083d4def70e0e9", "5c349d01a5083d4def711a75", "5c349f30a5083d4def7953a5", "5c349e36a5083d4def765050", "5c349ecea5083d4def78410b", "5c349d41a5083d4def7212bd", "5c349ce8a5083d4def70befc", "5c349d6da5083d4def72bda3", "5c349d04a5083d4def712746", "5c349d17a5083d4def717033", "5c349e3ba5083d4def765fe6", "5c349d41a5083d4def72113b", "5c349e90a5083d4def777e99", "5c349d7ca5083d4def72fa92", "5c05eed5a5083dca65551168", "5c349f26a5083d4def793219", "5c349fb9a5083d4def7b105f", "5c349d1aa5083d4def717af5", "5c349e28a5083d4def7621ae", "5c349eb3a5083d4def77eacd", "5c349cffa5083d4def7112eb", "5c349ee6a5083d4def787a61", "5c349eaaa5083d4def77cc0b", "5c349f1aa5083d4def7908a2", "5c36fee6a5083d427d8c3f95", "5c349d2fa5083d4def71cbf8", "5c349f2fa5083d4def7950a1", "5c349d34a5083d4def71df92", "5c3565e8a5083d4defb8a548", "5c36fee6a5083d427d8c4050", "5c349d37a5083d4def71eb89", "5c349d4ba5083d4def723a10", "5c349d52a5083d4def725673", "5c344667a5083deefd519dc2", "5c34a04aa5083d4def7d2172", "5c34a0a6a5083d4def7e5f6b", "5c356584a5083d4defb8018e", "5c349d26a5083d4def71a8b0", "5c349d53a5083d4def725a1f", "5c349d85a5083d4def731d61", "5c349d6aa5083d4def72b3d6", "5c36fed5a5083d427d8c0582", "5c36fd3ca5083d427d8af16f", "5c349d0aa5083d4def713aac", "5c349e13a5083d4def75d84c", "5c349fc9a5083d4def7b4c39", "5c349d6fa5083d4def72c6af", "5c349d21a5083d4def71972e", "5c34a0c1a5083d4def7ebf82", "5c349ceea5083d4def70d418", "5c349d82a5083d4def731204", "5c349e94a5083d4def778b96", "5c356054a5083d4defb648e6", "5c36fed4a5083d427d8c0125", "5c349ce9a5083d4def70c200", "5c36fed6a5083d427d8c0916", "5c34a0a5a5083d4def7e5d01", "5c349ceda5083d4def70d114", "5c349ceaa5083d4def70c686", "5c349f0da5083d4def78dbc8", "5c36fedea5083d427d8c2750", "5c349d2ca5083d4def71bfe8", "5c349f29a5083d4def793be6", "5c349d2fa5083d4def71ca76", "5c349cf9a5083d4def70fd93", "5c349d34a5083d4def71de10", "5c36fd3ca5083d427d8af22a", "5c349d48a5083d4def722d15", "5c349ea2a5083d4def77b62e", "5c34a063a5083d4def7d7ad6", "5c349d6da5083d4def72bfe6", "5c36fed5a5083d427d8c03e2", "5c349d81a5083d4def730fb3", "5c36fee6a5083d427d8c410b", "5c349f76a5083d4def7a2ef4", "5c36fecda5083d427d8bef50", "5c349ce9a5083d4def70c13f", "5c34a087a5083d4def7df5f9", "5c3565b2a5083d4defb862b8", "5c349eeba5083d4def7887eb", "5c3565afa5083d4defb858c9", "5c349f8aa5083d4def7a6df7", "5c3565b4a5083d4defb8697a", "5c349d33a5083d4def71dbcd", "5c3565a3a5083d4defb830be", "5c349d53a5083d4def725ba1", "5c349e8da5083d4def7773df", "5c36fee3a5083d427d8c352f", "5c349e4aa5083d4def7692b4", "5c349ee8a5083d4def787f46", "5c349d55a5083d4def7260e8", "5c36fed0a5083d427d8bf759", "5c349ee4a5083d4def787587", "5c349eeea5083d4def788e44", "5c34999fa5083d4def67b21a", "5c3559dea5083d4defb2bf14", "5c3565eda5083d4defb8b821", "5c34998ca5083d4def67832a", "5d47e189bc800c00010e01df", "5c349e8ea5083d4def777561", "5c349cf2a5083d4def70e26b", "5c3499fda5083d4def6898b9", "5c34999fa5083d4def67b086", "5c349b34a5083d4def6c079e", "5d429cfdbc800c00010c7914", "5c349d1ca5083d4def718435", "5c349e57a5083d4def76bece", "5c36fd34a5083d427d8ae09b", "5c36fed0a5083d427d8bf814", "5c349e11a5083d4def75d01a", "5c349fb0a5083d4def7af365", "5c349d05a5083d4def712bcc", "5c349d0ea5083d4def714cc4", "5c349f6aa5083d4def7a100b", "5c349e11a5083d4def75d0db", "5c349ac3a5083d4def6a5bd2", "5c349cf3a5083d4def70e7b2", "5c349d3ba5083d4def71f9dc", "5c349ed2a5083d4def784aa3", "5c349b02a5083d4def6b48cf", "5c349b4da5083d4def6c64e7", "5c3499dca5083d4def6845a3", "5c34999ea5083d4def67aef2", "5c349b54a5083d4def6c7c47", "5c349ae9a5083d4def6ae4a9", "5c3499f3a5083d4def68808f", "5c349989a5083d4def677a7e", "5c349aeda5083d4def6af2e1", "5c34996ba5083d4def673b8b", "5c349aafa5083d4def6a1fec", "5c3499d2a5083d4def682c4a", "5c349b06a5083d4def6b5826", "5c349b17a5083d4def6b99d3", "5c344726a5083deefd528210", "5c349a03a5083d4def68a623", "5c349a18a5083d4def68db53", "5c349b11a5083d4def6b8173", "5c349b17a5083d4def6b97f7", "5c349a10a5083d4def68c5b4", "5c349adda5083d4def6ab35a", "5c349afca5083d4def6b2dd9", "5c349b1aa5083d4def6ba40d", "5c3499f9a5083d4def688d94", "5c3499daa5083d4def6840e7", "5c349b0fa5083d4def6b7ae0", "5c34473aa5083deefd52a31b", "5c349ae7a5083d4def6ad922", "5c3499d3a5083d4def682f38", "5c3499d8a5083d4def683b62", "5c349ab3a5083d4def6a296b", "5c349adea5083d4def6ab701", "5c349a16a5083d4def68d5de", "5c34999aa5083d4def67a45c", "5c349acca5083d4def6a761e", "5c3499b3a5083d4def67e03d", "5c349b30a5083d4def6bfa78", "5c349b26a5083d4def6bd2cd", "5c344721a5083deefd527045", "5c3499ffa5083d4def689b7c", "5c34997ba5083d4def675a75", "5c349c50a5083d4def6e8095", "5c349b4aa5083d4def6c5c23", "5c349b24a5083d4def6bcdb0", "5c344849a5083deefd53c754", "5c349b54a5083d4def6c7d02", "5c349b32a5083d4def6bfeda", "5c349b37a5083d4def6c14c4", "5c34998ca5083d4def6784d2", "5c3499bba5083d4def67f3cf", "5c349b7ba5083d4def6d06c1", "5c349a07a5083d4def68af9b", "5c3499dca5083d4def68466d", "5c349b71a5083d4def6ce47f", "5c349979a5083d4def67571b", "5c34996ea5083d4def6740ac", "5c349b06a5083d4def6b58e1", "5c3499d0a5083d4def68278c", "5c349ae3a5083d4def6ac7d7", "5c349b14a5083d4def6b8dbd", "5c349b1da5083d4def6bb2a9", "5c3499f6a5083d4def68867a", "5c3499f7a5083d4def688a07", "5c349b18a5083d4def6b9ef0", "5c349b2ca5083d4def6bea64", "5c3499d9a5083d4def683e8a", "5c3499d3a5083d4def682e6e", "5c3499eca5083d4def686e69", "5c349b37a5083d4def6c11d8", "5c349a0fa5083d4def68c4ea", "5c349acda5083d4def6a7a80", "5c349b07a5083d4def6b5d43", "5c3499f9a5083d4def688d2f", "5c3499a7a5083d4def67c644", "5c349b50a5083d4def6c6f21", "5c349ab9a5083d4def6a3f03", "5c3499a1a5083d4def67b5bd", "5c349ab4a5083d4def6a2c57", "5c349ae7a5083d4def6ad9dd", "5c349b3da5083d4def6c2aae", "5c3499e9a5083d4def6866ea", "5c349981a5083d4def676857", "5c349afea5083d4def6b3923", "5c349b43a5083d4def6c411c", "5c349a09a5083d4def68b4bc", "5c349b20a5083d4def6bbab2", "5c344720a5083deefd526f50", "5c34997ca5083d4def675db0", "5c349998a5083d4def679fef", "5c3499c5a5083d4def680b15", "5c349b45a5083d4def6c4c11", "5c344858a5083deefd53ead5", "5c349b3ba5083d4def6c2360", "5c34996da5083d4def673eb3", "5c3499f8a5083d4def688cca", "5c349a08a5083d4def68b12f", "5c349ac0a5083d4def6a530e", "5c349b45a5083d4def6c4b56", "5c349b1ca5083d4def6bae47", "5c3499c7a5083d4def681027", "5c349ad0a5083d4def6a8344", "5c3499d5a5083d4def683482", "5c349af9a5083d4def6b207b", "5c349b79a5083d4def6d025f", "5c34996aa5083d4def6737c1", "5c3499b3a5083d4def67e0a2", "5c3499dfa5083d4def684d87", "5c349a00a5083d4def689f6e", "5c349aaca5083d4def6a1959", "5c349b2ea5083d4def6bf03c", "5c349b32a5083d4def6bff95", "5c349af5a5083d4def6b11f9", "5c349b0ca5083d4def6b70fc", "5c349b63a5083d4def6cb504", "5c3499d5a5083d4def6833b8", "5c349a0aa5083d4def68b7e4", "5c349b2ba5083d4def6be4c9", "5c349ab2a5083d4def6a27f5", "5c349b4aa5083d4def6c5b68", "5c349973a5083d4def67495a", "5c349b57a5083d4def6c8875", "5c349a15a5083d4def68d4af", "5c349b3ea5083d4def6c2d9a", "5c349aa2a5083d4def69fc80", "5c349af5a5083d4def6b12b4", "5c349a0aa5083d4def68b8ae", "5c349a0fa5083d4def68c485", "5c349acca5083d4def6a7563", "5ca1baf4a5083db8bacfe2ef", "5c349b69a5083d4def6cc978", "5c3499fba5083d4def6893e4", "5c349ab1a5083d4def6a244e", "5c349b2ca5083d4def6be9a9", "5c349a0fa5083d4def68c420", "5c349b14a5083d4def6b8f33", "5c349aaaa5083d4def6a0fdb", "5c349b1ea5083d4def6bb41f", "5c3499cea5083d4def6821d0", "5c3499daa5083d4def68414c", "5c349b71a5083d4def6ce24e", "5c34466aa5083deefd51a8d1", "5c34485ea5083deefd53f4c8", "5c3499eaa5083d4def6867b4", "5c349a1ca5083d4def68e64f", "5c349ac9a5083d4def6a6a6e", "5c349977a5083d4def675181", "5c349afea5083d4def6b36f2", "5c34997fa5083d4def676400", "5c349970a5083d4def67430a", "5c349b29a5083d4def6be001", "5c3499d9a5083d4def683eef", "5c3499f3a5083d4def687fc5", "5c349af8a5083d4def6b1cd4", "5c3499d6a5083d4def6836e0", "5c3499f5a5083d4def68841c", "5c349a09a5083d4def68b457", "5c3499efa5083d4def68751e", "5c349b22a5083d4def6bc2bb", "5c3499c2a5083d4def680276", "5c3499c7a5083d4def6810c4", "5c349affa5083d4def6b3c64", "5c34473fa5083deefd52aff7", "5c3499d6a5083d4def68367b", "5c349b75a5083d4def6cf24d", "5c349b6ca5083d4def6cd2f7", "5c349986a5083d4def67742d", "5c34998fa5083d4def678ae2", "5c349b77a5083d4def6cf99b", "5c3499d9a5083d4def683da3", "5c349c50a5083d4def6e7de2", "5c3499f0a5083d4def6877e1", "5c349b3ba5083d4def6c21ea", "5c349aa8a5083d4def6a0a40", "5c349abca5083d4def6a47d5", "5c3499dda5083d4def684995", "5c349b40a5083d4def6c34e8", "5c349b0ca5083d4def6b6ecb", "5c349b23a5083d4def6bc7d8", "5c349b5ca5083d4def6c99fd", "5c344724a5083deefd52798a", "5c349a1da5083d4def68e8ad", "5c349b0ca5083d4def6b6e10", "5c349b30a5083d4def6bf78c", "5c349c52a5083d4def6e87cf", "5c3499e9a5083d4def686581", "5c3499faa5083d4def689057", "5c349affa5083d4def6b3aee", "5c349abfa5083d4def6a4f67", "5c349b26a5083d4def6bd443", "5c349b67a5083d4def6cc0b4", "5c34485ba5083deefd53f066", "5c34996ca5083d4def673c55", "5c349a13a5083d4def68cde6", "5c349a10a5083d4def68c68c", "5c3499daa5083d4def6841b1", "5c349af5a5083d4def6b142f", "5c349b56a5083d4def6c8164", "5c349980a5083d4def67678d", "5c349ca8a5083d4def6fbfd3", "5c349cbba5083d4def700a59", "5c349c85a5083d4def6f3ae6", "5c349cb1a5083d4def6fe7da", "5c349c93a5083d4def6f6ed3", "5c349ca1a5083d4def6fa6e4", "5c349ce8a5083d4def70bbf8", "5c349cd3a5083d4def7064ca", "5c349c61a5083d4def6ebd3c", "5c349caba5083d4def6fcdbb", "5c349caca5083d4def6fd394", "5c349c63a5083d4def6ec4c6", "5c349c88a5083d4def6f43b5", "5c349c60a5083d4def6eb977", "5c349caba5083d4def6fccfa", "5c349cbea5083d4def701669", "5c349c88a5083d4def6f42f4", "5c349c62a5083d4def6ec1c2", "5c349c95a5083d4def6f7722", "5c349cc6a5083d4def70354b", "5c349c6da5083d4def6ee9b7", "5c349c95a5083d4def6f74b7", "5c349c64a5083d4def6ec94c", "5c349cbfa5083d4def701bb0", "5c349cb2a5083d4def6fe95c", "5c36fee8a5083d427d8c4607", "5c349c63a5083d4def6ec405", "5c349c57a5083d4def6e9927", "5c36fedca5083d427d8c1eb4", "5c349c98a5083d4def6f7e7d", "5c349ca0a5083d4def6fa305", "5c36fd43a5083d427d8b038a", "5c349c6aa5083d4def6edda7", "5c349c58a5083d4def6e9e79", "5c349c7ba5083d4def6f19f7", "5c349ce3a5083d4def70a76e", "5c349c6aa5083d4def6edce6", "5c349caaa5083d4def6fc935", "5c349cfba5083d4def71045c", "5c349c76a5083d4def6f08a0", "5c349c64a5083d4def6ec88b", "5c349cd4a5083d4def706a11", "5c349c63a5083d4def6ec344", "5c349c8da5083d4def6f560c", "5c349c89a5083d4def6f45f8", "5c349cd5a5083d4def706eb3", "5c349c73a5083d4def6eff94", "5c349c9fa5083d4def6f9f39", "5c349c90a5083d4def6f61ce", "5c349cc0a5083d4def701eb4", "5c349c97a5083d4def6f7c3a", "5c349ca8a5083d4def6fc1b3", "5c349c73a5083d4def6f0055", "5c349ce8a5083d4def70bd7a", "5c3566b1a5083d4defb9c418", "5c36fed7a5083d427d8c0bd3", "5c349e3ea5083d4def766a9e", "5c349d53a5083d4def72590a", "5c349e23a5083d4def7611ad", "5c349cb7a5083d4def6ffb45", "5c349c83a5083d4def6f30b2", "5c349c5da5083d4def6eb06b", "5c349c62a5083d4def6ec040", "5c349cd6a5083d4def7071b7", "5c349c81a5083d4def6f29cc", "5c349ce3a5083d4def70a888", "5c349c59a5083d4def6ea23e", "5c349c81a5083d4def6f2a8d", "5c349c99a5083d4def6f8242", "5c349c6ea5083d4def6eecbb", "5c349c6da5083d4def6ee774", "5c349c55a5083d4def6e93e0", "5c349c58a5083d4def6e9c2b", "5c349d2aa5083d4def71b85e", "5c349c69a5083d4def6ed921", "5c349e73a5083d4def771bfd", "5c349ca6a5083d4def6fb83b", "5c349c8ca5083d4def6f53ed", "5c3499d5a5083d4def68341d", "5c349d63a5083d4def729730", "5c349d61a5083d4def729067", "5c349c68a5083d4def6ed6de", "5c349e60a5083d4def76db11", "5c349c9fa5083d4def6f9caf", "5c349ccea5083d4def7052b2", "5c349c7ea5083d4def6f2242", "5c349cbda5083d4def701365", "5c349c6aa5083d4def6edc25", "5c349c5ea5083d4def6eb430", "5c349cafa5083d4def6fde0d", "5c349c65a5083d4def6ecace", "5c34472fa5083deefd529058", "5c34466fa5083deefd51b63f", "5c34471ca5083deefd5260bf", "5c344848a5083deefd53c523", "5c344849a5083deefd53c5de", "5c34484aa5083deefd53ca40", "5c344851a5083deefd53dfc4", "5c34486da5083deefd541511", "5c349988a5083d4def67794f", "5c34998ba5083d4def6780c9", "5c34998ea5083d4def678932", "5c349998a5083d4def67a054", "5c3499afa5083d4def67d5c1", "5c3499b9a5083d4def67ed4d", "5c3499bca5083d4def67f692", "5c3499c7a5083d4def681181", "5c3499c9a5083d4def6814d4", "5c3499e0a5083d4def684eb6", "5c3499eba5083d4def686a12", "5c3499f0a5083d4def6878ab", "5c3499f8a5083d4def688a6c", "5c3499faa5083d4def6891eb", "5c3499fca5083d4def6894ae", "5c3499fea5083d4def689b17", "5c349a01a5083d4def689fd3", "5c349a04a5083d4def68a81c", "5c349a07a5083d4def68b000", "5c349a0ba5083d4def68b9dd", "5c349a0ca5083d4def68bdcf", "5c349a0ea5083d4def68c1c1", "5c349a11a5083d4def68c7bb", "5c349a11a5083d4def68c93f", "5c349a13a5083d4def68cd81", "5c349a17a5083d4def68d7d7", "5c349aa6a5083d4def6a0544", "5c349ab6a5083d4def6a322f", "5c349ac2a5083d4def6a58e6", "5c349adaa5083d4def6aa6ef", "5c349adea5083d4def6ab4d0", "5c349aeea5083d4def6af5ce", "5c349b02a5083d4def6b4759", "5c349b27a5083d4def6bd73d", "5c349b58a5083d4def6c8b61", "5c349b59a5083d4def6c8cd7", "5c349c54a5083d4def6e901b", "5c349c7ca5083d4def6f1ab8", "5c349c82a5083d4def6f2fd4", "5c349d18a5083d4def71748a", "5c349d32a5083d4def71d808", "5c349d3ca5083d4def71fe62", "5c349d3da5083d4def7202e8", "5c349d43a5083d4def7218c5", "5c349d46a5083d4def7224ae", "5c349d4fa5083d4def7248e1", "5c349d5ca5083d4def727b4b", "5c349d60a5083d4def728be1", "5c349d6aa5083d4def72b0d2", "5c349d79a5083d4def72ee82", "5c349d7ba5083d4def72f60c", "5c349e0ea5083d4def75c288", "5c349e15a5083d4def75de54", "5c349e1ea5083d4def75fdfe", "5c349e25a5083d4def7619f8", "5c349e32a5083d4def76424a", "5c349e39a5083d4def76585b", "5c349e3ca5083d4def76646c", "5c349e40a5083d4def7672e9", "5c349e44a5083d4def767ff4", "5c349e55a5083d4def76ba8b", "5c349e6da5083d4def770957", "5c349e70a5083d4def7711a2", "5c349e7ba5083d4def77359f", "5c349e89a5083d4def7766c3", "5c349e8fa5083d4def777a13", "5c349e90a5083d4def777d17", "5c349e94a5083d4def778953", "5c349eb2a5083d4def77e708", "5c349eb3a5083d4def77e94b", "5c349eb7a5083d4def77f79e", "5c349ebba5083d4def78046f", "5c349ebda5083d4def780b38", "5c349ed0a5083d4def7845c9", "5c349ed8a5083d4def785ae2", "5c349f0aa5083d4def78d43e", "5c349f3da5083d4def797e56", "5c349fcba5083d4def7b53c3", "5c349ff9a5083d4def7c008c", "5c34a002a5083d4def7c1ed0", "5c34a023a5083d4def7c992a", "5c34a02fa5083d4def7cc43f", "5c34a04ea5083d4def7d2f04", "5c34a09ea5083d4def7e438c", "5c34a0a1a5083d4def7e4f3a", "5c34a0a2a5083d4def7e517d", "5c356573a5083d4defb7cbf7", "5c356583a5083d4defb7fdc9", "5c3565a4a5083d4defb83240", "5c3565aaa5083d4defb84772", "5c3565eda5083d4defb8b8e2", "5c344733a5083deefd529a89", "5c344867a5083deefd540397", "5c34996ba5083d4def673a5c", "5c34996fa5083d4def6742a5", "5c34997fa5083d4def6765f9", "5c344863a5083deefd53fb7b", "5c34999aa5083d4def67a4eb", "5c3499f8a5083d4def688b36", "5c349a0da5083d4def68be99", "5c349a1da5083d4def68e719", "5c349d57a5083d4def7267b1", "5c349e22a5083d4def760aec", "5c349982a5083d4def676be4", "5c3499a0a5083d4def67b30e", "5c3499b5a5083d4def67e4f9", "5c3499cea5083d4def682235", "5c3499d8a5083d4def683cf6", "5c3499dba5083d4def684474", "5c3499dda5083d4def684866", "5c3499dea5083d4def6849fa", "5c3499dea5083d4def684bf3", "5c3499e6a5083d4def685e02", "5c3499f3a5083d4def687efb", "5c3499f3a5083d4def68802a", "5c3499f7a5083d4def68880e", "5c3499faa5083d4def688ff2", "5c349a0ea5083d4def68c28b", "5c349a0fa5083d4def68c2f1", "5c349a0fa5083d4def68c356", "5c349a12a5083d4def68c9ea", "5c349a14a5083d4def68cfdf", "5c349a14a5083d4def68d0a9", "5c349a15a5083d4def68d31b", "5c349a1ba5083d4def68e38b", "5c349aa4a5083d4def6a0027", "5c349aada5083d4def6a1acf", "5c349aaea5083d4def6a1c45", "5c349ab4a5083d4def6a2d12", "5c349abea5083d4def6a4df1", "5c349ac6a5083d4def6a6320", "5c349af9a5083d4def6b2136", "5c349b05a5083d4def6b53c4", "5c349b15a5083d4def6b92da", "5c349b25a5083d4def6bcf26", "5c349b2ba5083d4def6be6fa", "5c349b3ba5083d4def6c24d6", "5c349b42a5083d4def6c3cba", "5c349b49a5083d4def6c5706", "5c349b58a5083d4def6c8aa6", "5c349b69a5083d4def6cc8bd", "5c349c50a5083d4def6e7d21", "5c349c5aa5083d4def6ea481", "5c349c70a5083d4def6ef5c7", "5c349c75a5083d4def6f071e", "5c349c8ba5083d4def6f5057", "5c349c92a5083d4def6f6a24", "5c349c95a5083d4def6f7636", "5c349ca5a5083d4def6fb5f8", "5c349ca7a5083d4def6fbe43", "5c349cb0a5083d4def6fe354", "5c349cb6a5083d4def6ffa84", "5c349ccfa5083d4def7057f9", "5c349cd1a5083d4def705e01", "5c349cd9a5083d4def707c34", "5c349cdca5083d4def7088a4", "5c349cdea5083d4def709406", "5c349ce2a5083d4def70a53c", "5c349cefa5083d4def70d95f", "5c349d00a5083d4def7118f3", "5c349d0ea5083d4def714b42", "5c349d13a5083d4def715e1b", "5c349d13a5083d4def715edc", "5c349d1da5083d4def7188bf", "5c349d21a5083d4def7195ac", "5c349d24a5083d4def71a2a8", "5c349d3aa5083d4def71f799", "5c349d3da5083d4def720166", "5c349d47a5083d4def722873", "5c349d4ba5083d4def723ad1", "5c349d4ea5083d4def7242d9", "5c349d4ea5083d4def72439a", "5c349d58a5083d4def726c37", "5c349d5aa5083d4def7273c1", "5c349d61a5083d4def728e24", "5c349d6ca5083d4def72ba9f", "5c349d6da5083d4def72bce2", "5c349d6ea5083d4def72c2ea", "5c349d6fa5083d4def72c52d", "5c349d71a5083d4def72cd78", "5c349d75a5083d4def72e021", "5c349d82a5083d4def731082", "5c349e0da5083d4def75c106", "5c349e14a5083d4def75d90d", "5c349e14a5083d4def75d9ce", "5c349e14a5083d4def75da8f", "5c349e1aa5083d4def75eeea", "5c349e2aa5083d4def762963", "5c349e36a5083d4def765111", "5c349e3aa5083d4def765da3", "5c349e3ba5083d4def7660a7", "5c349e45a5083d4def768237", "5c349e48a5083d4def768cac", "5c349e4da5083d4def769cbc", "5c349e4ea5083d4def76a142", "5c349e65a5083d4def76edb5", "5c349e68a5083d4def76f9fd", "5c349e6ba5083d4def77010c", "5c349e6ca5083d4def7704d1", "5c349e6da5083d4def770714", "5c349e70a5083d4def771378", "5c349e72a5083d4def7718f9", "5c349e75a5083d4def772144", "5c349e77a5083d4def77274c", "5c349e7da5083d4def773d8f", "5c349e80a5083d4def774543", "5c349e88a5083d4def77627c", "5c349e9ca5083d4def77a3c1", "5c349e9da5083d4def77a7da", "5c349ea0a5083d4def77aea4", "5c349ea6a5083d4def77c0bc", "5c349eb1a5083d4def77e4c5", "5c349eb2a5083d4def77e647", "5c349eb3a5083d4def77ec4f", "5c349eb4a5083d4def77edd1", "5c349ebea5083d4def780f37", "5c349ebfa5083d4def78117a", "5c349ec1a5083d4def7818a2", "5c349ecba5083d4def78373e", "5c349ed5a5083d4def785238", "5c349edda5083d4def7868cb", "5c349ef2a5083d4def78976c", "5c349ef5a5083d4def789da0", "5c349efba5083d4def78aa9d", "5c349f03a5083d4def78bfb9", "5c349f04a5083d4def78c40a", "5c349f15a5083d4def78f62b", "5c349f16a5083d4def78fb72", "5c349f19a5083d4def79059e", "5c349f25a5083d4def792d93", "5c349f2aa5083d4def794138", "5c349f34a5083d4def795e6d", "5c349f38a5083d4def796b3e", "5c349f48a5083d4def79a7ca", "5c349f4ba5083d4def79b263", "5c349f4ea5083d4def79bbc3", "5c349f51a5083d4def79c52e", "5c349f53a5083d4def79ca80", "5c349f6ea5083d4def7a1c1b", "5c349f75a5083d4def7a2bf0", "5c349f81a5083d4def7a5239", "5c349f88a5083d4def7a68b0", "5c349f92a5083d4def7a8ad2", "5c349f95a5083d4def7a9286", "5c349fb4a5083d4def7affc9", "5c349fbfa5083d4def7b294b", "5c349ffca5083d4def7c0c9c", "5c34a001a5083d4def7c1b0b", "5c34a017a5083d4def7c7058", "5c34a01fa5083d4def7c8cfe", "5c34a054a5083d4def7d44c1", "5c34a069a5083d4def7d8d42", "5c34a06ca5083d4def7d99d4", "5c34a072a5083d4def7dafb1", "5c34a07aa5083d4def7dc79d", "5c34a080a5083d4def7ddbf8", "5c34a081a5083d4def7ddefc", "5c34a088a5083d4def7df6ba", "5c34a0aba5083d4def7e7233", "5c34a0aea5083d4def7e7c19", "5c34a0aea5083d4def7e7e8d", "5c34a0c6a5083d4def7ed528", "5c34a0cea5083d4def7ef34e", "5c3559dca5083d4defb2b84b", "5c3559eda5083d4defb2f003", "5c356048a5083d4defb6189d", "5c35604aa5083d4defb62027", "5c35604ca5083d4defb629bb", "5c35604ea5083d4defb63394", "5c356056a5083d4defb64e73", "5c356059a5083d4defb656be", "5c356572a5083d4defb7c832", "5c35657ea5083d4defb7ef3c", "5c35657fa5083d4defb7f483", "5c3565a2a5083d4defb82b77", "5c3565a2a5083d4defb82cf9", "5c3565afa5083d4defb8598a", "5c3565f6a5083d4defb8d8e3", "5c3565f8a5083d4defb8de2a", "5c3566b3a5083d4defb9cdeb", "5c3566baa5083d4defb9e7af", "5c36fd33a5083d427d8adfe0", "5c36fd40a5083d427d8afb81", "5c36fecba5083d427d8beba9", "5c36fed6a5083d427d8c0815", "5c36fedca5083d427d8c1f70", "5c36fee1a5083d427d8c2f57", "5c36fee3a5083d427d8c33b9", "5c349a1da5083d4def68e6b4", "5c344734a5083deefd529b44", "5c34473da5083deefd52aa1f", "5c344662a5083deefd518eb4", "5c344664a5083deefd519340", "5c34466ba5083deefd51aca1", "5c34471ca5083deefd526004", "5c344724a5083deefd527ab6", "5c34473ca5083deefd52a7ee", "5c34484ea5083deefd53d5eb", "5c344852a5083deefd53e1f5", "5c344853a5083deefd53e59c", "5c344859a5083deefd53ec1e", "5c34485ca5083deefd53f297", "5c344864a5083deefd53fdd4", "5c344867a5083deefd540279", "5c3498c6a5083d4def66386b", "5c3498caa5083d4def664361", "5c3498caa5083d4def66442b", "5c349977a5083d4def67511c", "5c34997aa5083d4def67589e", "5c34997ca5083d4def675d4b", "5c34998ba5083d4def677fb9", "5c349991a5083d4def678f9e", "5c349999a5083d4def67a393", "5c3499a7a5083d4def67c515", "5c3499b8a5083d4def67eb81", "5c3499bfa5083d4def67fce2", "5c3499bfa5083d4def67fdac", "5c3499d7a5083d4def6839ce", "5c3499e0a5083d4def684f80", "5c3499e1a5083d4def68530d", "5c3499e8a5083d4def6862be", "5c3499e8a5083d4def686452", "5c3499f0a5083d4def687975", "5c3499f7a5083d4def688873", "5c3499fda5083d4def6897d0", "5c349a16a5083d4def68d643", "5c349a19a5083d4def68dd3b", "5c349abaa5083d4def6a3fbe", "5c349abda5083d4def6a4991", "5c349ac6a5083d4def6a63db", "5c349ac7a5083d4def6a6551", "5c349ac7a5083d4def6a660c", "5c349acaa5083d4def6a6ed0", "5c349acca5083d4def6a76d9", "5c349ad1a5083d4def6a8575", "5c349ad3a5083d4def6a8d7e", "5c349ad7a5083d4def6a9b2b", "5c349ad8a5083d4def6a9ed2", "5c349adca5083d4def6aac0c", "5c349ae7a5083d4def6adc0e", "5c349ae8a5083d4def6add03", "5c349aeaa5083d4def6ae6da", "5c349aeda5083d4def6af39c", "5c349aefa5083d4def6afa30", "5c349af0a5083d4def6afe92", "5c349af0a5083d4def6aff4d", "5c349afaa5083d4def6b270e", "5c349afba5083d4def6b2884", "5c349afda5083d4def6b30c5", "5c349b06a5083d4def6b56b0", "5c349b0ba5083d4def6b6bdf", "5c349b0ba5083d4def6b6c9a", "5c349b10a5083d4def6b80b8", "5c349b13a5083d4def6b88c1", "5c349b15a5083d4def6b8fee", "5c349b22a5083d4def6bc376", "5c349b23a5083d4def6bc662", "5c349b2ea5083d4def6bf0f7", "5c349b2ea5083d4def6bf209", "5c349b31a5083d4def6bfe1f", "5c349b3ea5083d4def6c2fcb", "5c349b46a5083d4def6c4ccc", "5c349b4ca5083d4def6c642c", "5c349b52a5083d4def6c74f9", "5c349b58a5083d4def6c89eb", "5c349b61a5083d4def6cab85", "5c349b68a5083d4def6cc747", "5c349c50a5083d4def6e7f64", "5c349c51a5083d4def6e848a", "5c349c5da5083d4def6eafaa", "5c349c6ca5083d4def6ee5f2", "5c349c84a5083d4def6f359f");
        List<JSONObject> priceBookProductList = productIds.stream().map(o -> {
            JSONObject jsonObject = JSON.parseObject(json);
            jsonObject.put("product_id", o);
            jsonObject.put("name", UUID.randomUUID());
            return jsonObject;
        }).collect(Collectors.toList());
        System.out.println(priceBookProductList);
    }


    //1570：北京嘉和一品企业管理有限公司
//1571：北京嘉多乐食品科技有限公司
    @Test
    public void should_category_test() throws IOException, InvalidFormatException {
        System.out.println(should_category());
    }

    public Map<String, List<String>> should_category() throws IOException, InvalidFormatException {
        String fileName = "/Users/chenqx/Downloads/临时/嘉和一品销售动态数据收集表20191029第二版xlsx.xlsx";
        ArrayList<Integer> priceBookCategoryIndex = Lists.newArrayList(0, 1);

        //key是组名，value包含的客户
        Map<String, List<String>> result = Maps.newHashMap();

        File xlsFile = new File(fileName);

        Workbook workbook = WorkbookFactory.create(xlsFile);
        //我们的需求只需要处理一个表，因此不需要遍历
        Sheet sheet = workbook.getSheetAt(6);

        // 行数
        int rowNumbers = sheet.getLastRowNum() + 1;

        for (int row = 1; row < rowNumbers; row++) {
            Row r = sheet.getRow(row);
            String accountCategory = r.getCell(0).toString();
            String accountName = r.getCell(1).toString();
            result.computeIfAbsent(accountCategory, o -> Lists.newArrayList());
            result.get(accountCategory).add(accountName);
        }
        return result;
    }

    public Map<String, List<String>> should_category1() throws IOException, InvalidFormatException {
        String s = IOUtils.toString(getClass().getClassLoader().getResource("category.json"), "UTF-8");
        List<JSONObject> jsonObjects = JSON.parseArray(s, JSONObject.class);

        Map<String, List<String>> result = Maps.newHashMap();

        for (JSONObject jsonObject : jsonObjects) {
            String accountName = jsonObject.get("name").toString();
            String accountCategory = jsonObject.get("value13").toString();
            result.computeIfAbsent(accountCategory, o -> Lists.newArrayList());
            result.get(accountCategory).add(accountName);
        }
        return result;
    }


    @Test
    public void should_category_data() throws IOException, InvalidFormatException {
        String fileName = "/Users/chenqx/Downloads/临时/价目表数据10.29.xlsx";
        ArrayList<Integer> priceBookCategoryIndex = Lists.newArrayList(0);


        ArrayList<JSONObject> result = Lists.newArrayList();
        File xlsFile = new File(fileName);
        Map<String, List<String>> categoryMap = should_category1();
        Workbook workbook = WorkbookFactory.create(xlsFile);
        //我们的需求只需要处理一个表，因此不需要遍历
        List<Sheet> sheets = priceBookCategoryIndex.stream().map(workbook::getSheetAt).collect(Collectors.toList());
        for (Sheet sheet : sheets) {
            // 行数
            int rowNumbers = sheet.getLastRowNum() + 1;

            for (int row = 1; row < rowNumbers; row++) {
                Row r = sheet.getRow(row);
                if (r.getCell(7) == null) continue;
                String productName = r.getCell(6).toString();
                if (productName.contains("失效") || productName.contains("无效")) continue;

                String categoryName = r.getCell(7).toString().trim();
                List<String> accountNameList = categoryMap.get(categoryName);
                if (CollectionUtils.isEmpty(accountNameList)) continue;
                String suffixName = r.getCell(2).toString().substring(0, r.getCell(2).toString().indexOf("."));

                String price = r.getCell(14).toString();
                String salesPriceBookId = r.getCell(8).toString();  //价目表id   field_price_list__c
                salesPriceBookId = salesPriceBookId.substring(0, salesPriceBookId.indexOf("."));

                for (String accountName : accountNameList) {

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("pricebook_id", pricenameToId.get(accountName + "_" + suffixName));
                    jsonObject.put("product_id", nameToId.get(productName));
                    jsonObject.put("pricebook_sellingprice", price);
                    if (pricenameToId.get(accountName + "_" + suffixName) == null) {
                        System.out.println(accountName + "_" + suffixName);
                    }
                    if (nameToId.get(productName) == null) {
                        System.out.println(productName);
                    }

                    jsonObject.put("field_price_list__c", salesPriceBookId);
                    result.add(jsonObject);
//                    stringBuffer.append("(bp.name='").append(productName).append("' and ").append("pb.name='").append(accountName).append(suffixName).append("') or");
                }


            }
        }
        System.out.println(result.toString());
//        System.out.println(stringBuffer);
    }

    @Test
    public void should_person() throws IOException, InvalidFormatException {
        String fileName = "/Users/chenqx/Downloads/临时/价目表数据10.29.xlsx";
        ArrayList<Integer> priceBookCategoryIndex = Lists.newArrayList(0);
        StringBuffer stringBuffer = new StringBuffer();


        ArrayList<JSONObject> result = Lists.newArrayList();
        File xlsFile = new File(fileName);
        Workbook workbook = WorkbookFactory.create(xlsFile);
        //我们的需求只需要处理一个表，因此不需要遍历
        List<Sheet> sheets = priceBookCategoryIndex.stream().map(workbook::getSheetAt).collect(Collectors.toList());
        for (Sheet sheet : sheets) {
            // 行数
            int rowNumbers = sheet.getLastRowNum() + 1;

            for (int row = 1; row < rowNumbers; row++) {
                Row r = sheet.getRow(row);
                if (r.getCell(4) == null) continue;
                String productName = r.getCell(6).toString();

                if (productName.contains("失效") || productName.contains("无效")) continue;

                String accountName = r.getCell(4).toString().trim();
                if (StringUtils.isEmpty(accountName)) continue;
                String suffixName = r.getCell(2).toString().substring(0, r.getCell(2).toString().indexOf("."));

                String salesPriceBookId = r.getCell(8).toString();  //价目表id   field_price_list__c
                salesPriceBookId = salesPriceBookId.substring(0, salesPriceBookId.indexOf("."));

                String price = r.getCell(14).toString();
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("pricebook_id", pricenameToId.get(accountName + "_" + suffixName));
                jsonObject.put("product_id", nameToId.get(productName));
                jsonObject.put("pricebook_sellingprice", price);
                if (pricenameToId.get(accountName + "_" + suffixName) == null) {
                    System.out.println(accountName + "_" + suffixName);
                }
                if (nameToId.get(productName) == null) {
                    System.out.println(productName);
                }
                jsonObject.put("field_price_list__c", salesPriceBookId);
                result.add(jsonObject);
            }
        }
        System.out.println(result.toString());
        System.out.println(result.size());
    }


    @Test
    public void should_() throws IOException, InvalidFormatException {
        String fileName = "/Users/chenqx/Downloads/临时/嘉和一品销售动态数据收集表20191029第二版xlsx.xlsx";
        ArrayList<Integer> priceBookCategoryIndex = Lists.newArrayList(0, 1);
        StringBuffer stringBuffer = new StringBuffer();


        ArrayList<JSONObject> result = Lists.newArrayList();
        File xlsFile = new File(fileName);
        Workbook workbook = WorkbookFactory.create(xlsFile);
        Row row = workbook.getSheetAt(0).getRow(22);
        System.out.println("");

    }

    @Test
    public void should_11() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.get());
    }


    @Test
    public void should_bushua() throws Exception {
        Map<Object, JSONObject> map = read("/Users/chenqx/Downloads/临时/价目表数据10.29.xlsx");
        String fileName = "/Users/chenqx/Downloads/临时/需要补刷的.xlsx";
        ArrayList<Integer> priceBookCategoryIndex = Lists.newArrayList(0);
        StringBuffer stringBuffer = new StringBuffer();


        ArrayList<JSONObject> result = Lists.newArrayList();
        File xlsFile = new File(fileName);
        Workbook workbook = WorkbookFactory.create(xlsFile);
        //我们的需求只需要处理一个表，因此不需要遍历
        List<Sheet> sheets = priceBookCategoryIndex.stream().map(workbook::getSheetAt).collect(Collectors.toList());
        for (Sheet sheet : sheets) {
            // 行数
            int rowNumbers = sheet.getLastRowNum() + 1;

            for (int row = 1; row < rowNumbers; row++) {
                Row r = sheet.getRow(row);
                String productName = r.getCell(6).toString();

                if (productName.contains("失效") || productName.contains("无效")) continue;

//                String salesPriceBookId = r.getCell(8).toString();  //价目表id   field_price_list__c
//                salesPriceBookId = salesPriceBookId.substring(0, salesPriceBookId.indexOf("."));

//                String price = r.getCell(14).toString();
                JSONObject jsonObject = new JSONObject();
                Object productId = nameToId.get(productName);
                JSONObject jsonObject1 = map.get(productId);
                if (jsonObject1 == null) continue;
//                jsonObject.put("product_id", nameToId.get(productName));
//                jsonObject.put("pricebook_sellingprice", price);
//                if (nameToId.get(productName) == null) {
//                    System.out.println(productName);
//                }
//                jsonObject.put("field_price_list__c", salesPriceBookId);
                jsonObject1.remove("tenant_id");
                jsonObject1.remove("owner");
                jsonObject1.remove("object_describe_api_name");
                jsonObject1.remove("object_describe_id");
                jsonObject1.remove("discount");
                jsonObject1.remove("record_type");
                jsonObject1.remove("field_baseprice__c");
                jsonObject1.remove("field_finance__c");
                jsonObject1.put("field_price_list__c", null);
                result.add(jsonObject1);
            }
        }
        System.out.println(result.toString());
        System.out.println(result.size());
    }

    @Test
    public void should_1() {
        ArrayList<Object> objects = Lists.newArrayList();
        for (String s : "无铝泡打粉_1*10*2.5kg,干锅酱_1*10*1kg,美味莲藕片_1*4*4kg,卤蛋(新)_1*40*245g,苏伯蛋花汤_1*4*800g,豆浆粉_1*30*300g,速食豆腐花_1*30*260g,北冰洋（橙味）_1*24*330ml,百事可乐_1*24*330ml,冰红茶_1*24*310ml,酸梅汤（桂花山楂乌梅饮料）_1*24*310ml,露露_1*24*240ml,椒叶黄瓜_1*200*30g,面筋_1*100g,椒叶黄瓜_1*10*1kg,凉皮（凉皮+麻酱+秘制料水）_1*10,秘制辣椒油_1*300g,黄豆小咸菜_1*500g,炸豆腐_1*500g,虾仁_1*250g,黑豆五香豆腐丝_1*70*400g,蟹田长粒香_抽真空,美味莲藕段_1*20*500g,嘉多乐扁豆焖面_1*340g,绿茶冰粥底_1*1kg,绿豆沙_1*1kg,酸梅汤_1*1kg,八宝粥_1*840g,红豆薏米美肤粥_1*840g,红枣山药糙米粥_1*840g,南瓜粥_1*840g,皮蛋瘦肉粥_1*840g,小米粥早餐_1*840g,莲子核桃黑米粥_1*840g,凉菜料油_1*1kg,鸡米粥_1*840g,冷冻玉米面浆_1*1.08kg,冻货豆沙包_1*10*80g,冷冻角瓜鸡蛋包_1*10*80g,冷冻香菇油菜包_1*10*80g,冷冻鱼香肉包_1*10*80g,冷冻猪肉大葱包_1*10*80g,冷冻猪肉萝卜包_1*10*80g,冷冻猪肉茄子包_1*10*80g,冷冻猪肉圆白菜粉条包_1*10*80g,冻货-油条面_1*1kg,冷冻马齿苋蒸饺_1*20*32g,冻货三鲜干蒸烧卖_1*24*30g,冷冻酱肉包（新）_1*24*40g,冻货-馒头_1*30*60g,冻货奶黄包_1*15*38g,嘉多乐枣发糕_1*6*50g,冻货豆沙笨笨熊_1*12*38g,冷冻焖面汁_1*1kg,冷冻双椒焖面_1*1kg,袋装扁豆焖面_1*5*300g,嘉多乐扁豆焖面_1*300g,冻货麻辣香锅面_1*360g,嘉多乐（300+60）扁豆焖面_1*360g,嘉多乐扁豆焖面_1*360g,速冻八宝粥_1*840g,速冻荷叶绿豆冰粥_1*840g,速冻红豆薏米美肤粥_1*840g,速冻红枣山药糙米粥_1*840g,速冻蓝莓山药冰粥_1*840g,速冻绿豆粥（热）_1*840g,速冻南瓜粥_1*840g,速冻皮蛋瘦肉粥_1*840g,速冻香甜芒果冰粥_1*840g,速冻小米粥早餐_1*840g,速冻白粥_1*1kg,速冻八宝粥_1*350g,速冻香菇鸡肉粥_1*350g,速冻红豆薏米粥_1*350g,速冻南瓜粥_1*350g,速冻皮蛋瘦肉粥_1*350g,速冻莲子核桃黑米粥_1*840g,冷冻酸菜鱼汤_1*550g,冷冻炒烤松板肉_1*100g,猪肉丸_1*1kg,冷冻小吊梨汤_1*330g,冷冻腊汁酱肉_1*1kg,冻货-豉汁排骨_1*1kg,冻货-紫金凤爪_1*1kg,冻货-香菇卤肉_1*200g,冷冻宫保鸡丁_1*210g,冷冻鱼香肉丝_1*210g,冷冻四喜烤麸_1*250g,冷冻肉丝炒酸菜_1*2*180g,酸菜肉丝汤_1*300g,酸汤鸡丝_1*300g,冷冻蘑菇鸡汤_1*350g,冷冻酸菜肉丝汤_1*350g,冷冻酸汤鸡丝_1*350g,冷冻芽菜肉臊子_1*350g,冷冻金汤_1*400g,冷冻酸汤_1*400g,冷冻丸子汤_1*400g,冷冻鱼香茄子_1*400g,冻货-凉面汁_1*500g,冷冻白灼汁_1*500g,冷冻炖汤（正餐）_1*500g,冷冻酱牛腱_1*500g,冷冻酱肘子_1*500g,冷冻卤汤_1*500g,冷冻卤琵琶腿_1*500g,冻货老北京扣肉（豆皮）_1*180g,冻货鱼香茄子_1*220g,冷冻扬州炒饭_1*450g,冷冻黄焖鸡_1*500g,冷冻五花肉片_1*500g,蘑菇鸡汤_1*300g,冷冻深夜冒菜_1*410g（320g原料+90g酱料）,南瓜发糕_1*8*540g,六和美食玉米蔬菜猪肉蒸饺_1*8*50*20g,六和美食猪肉荠菜蒸饺_1*8*50*20g,六和美食菌菇三鲜蒸饺_1*8*1kg,香糯米藕_1*7kg,素三鲜锅贴_1*6*750g,猪肉圆白菜锅贴_1*6*750g,肉夹馍饼胚_1*6*2kg,30g虾饺_1*6*24,奶香小馒头_1*5*1.5kg,酱香小肉包_1*4*65/23g,小荠菜鸡蛋包_1*4*65/23g,咖喱牛肉包_1*4*65/23g,香菇素菜包_1*4*45/33g,芝麻球（红糖）_1*4*40/56g,菜角（韭菜合子）_1*4*30/85g,火烧饼胚_1*4*30*120g,脆骨肉丸_1*2.5kg,火锅鸭血_1*20*400g,麻酱糖饼_1*300g,手抓饼_1*2*10*300g,上海灌汤包_1*18*360g,三全三鲜馄饨_1*16*500g,奥尔良风味鸡肉蔬菜卷饼_1*15*700g,香菇青菜包_1*12*800g,酱香肉包_1*12*800g,12个荠菜包（38g）_1*12*465g,梅干菜包_1*12*360g,新盐酥鸡_1*12*1kg,葱油饼（新）_1*12*1.2kg,牛肉馅饼_1*12*1.25kg,冻带鱼_1*10kg,三鲜蒸饺_1*10*900g,糯米烧卖_1*10*800g,荠菜鸡蛋包_1*10*800g,翅中_1*10*1kg,小酥肉（美好）_1*10*1kg,雪花鸡柳_1*10*1kg,台湾肉粒肠（德式风味）_1*10*1000g,冷冻口水鸡汁_1*400g,速冻鸡米粥_1*840g,速冻南瓜粥（嘉多乐）_1*450g,速冻八宝粥（嘉多乐）_1*450g,冷冻红烧丸子_1*270g,冷冻麻辣牛肉汤（新）JYB_1*380g,墨鱼风味丸串_1*10*800g".split(",")) {
            objects.add(nameToId.get(s));
        }
        System.out.println(objects);
        System.out.println(objects.size());
    }

    @Test
    public void should_ss() {
        //0.2==0.20
        System.out.println(new BigDecimal("0.2")
                .equals(new BigDecimal("0.20")));
        System.out.println(new BigDecimal("0.2")
                .compareTo(new BigDecimal("0.2")));
    }


    @Test
    public void should_pricebook_id() throws Exception {
        String fileName = "/Users/chenqx/Downloads/临时/20.xlsx";
        ArrayList<Integer> priceBookCategoryIndex = Lists.newArrayList(0);

        ArrayList<JSONObject> result = Lists.newArrayList();
        File xlsFile = new File(fileName);
        Workbook workbook = WorkbookFactory.create(xlsFile);
        //我们的需求只需要处理一个表，因此不需要遍历
        List<Sheet> sheets = priceBookCategoryIndex.stream().map(workbook::getSheetAt).collect(Collectors.toList());
        for (Sheet sheet : sheets) {
            // 行数
            int rowNumbers = sheet.getLastRowNum() + 1;

            for (int row = 1; row < rowNumbers; row++) {
                Row r = sheet.getRow(row);
                String productName = r.getCell(0).toString();
                String priceBookName = r.getCell(14).toString();

                String salesPriceBookId = r.getCell(1).toString();  //价目表id   field_price_list__c
                salesPriceBookId = salesPriceBookId.substring(0, salesPriceBookId.indexOf("."));

                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("product_id", nameToId.get(productName));
                jsonObject1.put("pricebook_id", pricenameToId.get(priceBookName));
                if (nameToId.get(productName) == null) {
                    System.out.println(productName);
                }
                if (pricenameToId.get(priceBookName) == null) {
                    System.out.println(priceBookName);
                }
                jsonObject1.put("field_price_list__c", salesPriceBookId);
                if (salesPriceBookId == null) {
                    System.out.println("!!!!" + productName);
                }
                result.add(jsonObject1);
            }
        }
        System.out.println(result.toString());
        System.out.println(result.size());
    }

    @Test
    public void should_1111() {
        JSONObject jsonObject = JSON.parseObject("{\n" +
                "    \"78005\": 1,\n" +
                "    \"114608\": 1,\n" +
                "    \"304290\": 6,\n" +
                "    \"489068\": 1,\n" +
                "    \"501903\": 1,\n" +
                "    \"504622\": 1,\n" +
                "    \"511164\": 16,\n" +
                "    \"540053\": 1,\n" +
                "    \"544617\": 8,\n" +
                "    \"577932\": 1,\n" +
                "    \"579156\": 5,\n" +
                "    \"584982\": 1,\n" +
                "    \"587883\": 1,\n" +
                "    \"588892\": 2,\n" +
                "    \"590048\": 1,\n" +
                "    \"590061\": 1,\n" +
                "    \"590062\": 1,\n" +
                "    \"590083\": 2,\n" +
                "    \"590158\": 1,\n" +
                "    \"593312\": 2,\n" +
                "    \"594003\": 1,\n" +
                "    \"608836\": 4,\n" +
                "    \"614652\": 1,\n" +
                "    \"616146\": 1,\n" +
                "    \"619040\": 2,\n" +
                "    \"620942\": 4,\n" +
                "    \"629128\": 1,\n" +
                "    \"630808\": 1,\n" +
                "    \"633620\": 1,\n" +
                "    \"641919\": 1,\n" +
                "    \"642849\": 1,\n" +
                "    \"647547\": 3,\n" +
                "    \"647761\": 1,\n" +
                "    \"649756\": 1,\n" +
                "    \"652038\": 30,\n" +
                "    \"652887\": 2,\n" +
                "    \"653215\": 2,\n" +
                "    \"653783\": 8,\n" +
                "    \"654209\": 11,\n" +
                "    \"654462\": 6,\n" +
                "    \"655423\": 1,\n" +
                "    \"656644\": 16,\n" +
                "    \"657460\": 30,\n" +
                "    \"660587\": 1,\n" +
                "    \"662981\": 6,\n" +
                "    \"663048\": 2,\n" +
                "    \"663830\": 2,\n" +
                "    \"664150\": 1,\n" +
                "    \"664711\": 1,\n" +
                "    \"664884\": 1,\n" +
                "    \"665329\": 1,\n" +
                "    \"667745\": 1,\n" +
                "    \"667921\": 1,\n" +
                "    \"668513\": 1,\n" +
                "    \"670398\": 2,\n" +
                "    \"670742\": 3,\n" +
                "    \"674796\": 1,\n" +
                "    \"675034\": 1,\n" +
                "    \"675059\": 7,\n" +
                "    \"675478\": 1,\n" +
                "    \"679499\": 6,\n" +
                "    \"679808\": 1,\n" +
                "    \"682739\": 2,\n" +
                "    \"683186\": 3,\n" +
                "    \"683827\": 3\n" +
                "}");
        ArrayList<Object> objects = Lists.newArrayList("662502", "662503", "662505", "662506", "662507", "662508", "662509", "662510", "662511", "662512", "662514", "662515", "662516", "662518", "662519", "662520", "662521", "662522", "662523", "662524", "662945", "662946", "662947", "662948", "662949", "662950", "662951", "662952", "662953", "662954", "662955", "662956", "662957", "662958", "662959", "662960", "662961", "662962", "662963", "662964", "662965", "662966", "662967", "662968", "662969", "662971", "662972", "662973", "662974", "662975", "662976", "662977", "662978", "662979", "662980", "662981", "662982", "662983", "662984", "662985", "662986", "662987", "662988", "662989", "662990", "662991", "662992", "662993", "662994", "662995", "662996", "662997", "662998", "662999", "663000", "663001", "663002", "663003", "663004", "663005", "663006", "663007", "663008", "663009", "663010", "663011", "663012", "663013", "663014", "663015", "663016", "663017", "663018", "663019", "663020", "663021", "663022", "663023", "663024", "663025", "663026", "663027", "663028", "663029", "663030", "663031", "663032", "663033", "663034", "663035", "663036", "663037", "663038", "663039", "663040", "663041", "663042", "663043", "663046", "663047", "663048", "663049", "663050", "663051", "663052", "663053", "663054", "663055", "663056", "663057", "663058", "663059", "663060", "663061", "663062", "663063", "663064", "663065", "663066", "663067", "663068", "663069", "663070", "663071", "663072", "663073", "663074", "663075", "663076", "663077", "663078", "663079", "663080", "663081", "663082", "663083", "663084", "663085", "663086", "663087", "663088", "663089", "663090", "663091", "663092", "663093", "663094", "663095", "663096", "663097", "663098", "663099", "663100", "663101", "663102", "663103", "663104", "663105", "663106", "663107", "663108", "663109", "663110", "663111", "663112", "663113", "663114", "663115", "663117", "663118", "663119", "663120", "663121", "663122", "663123", "663124", "663125", "663044", "663045", "663116", "679400", "679401", "679402", "679403", "679404", "679405", "679406", "679407", "679408", "679409", "679410", "679411", "679412", "679413", "679414", "679415", "679416", "679417", "679418", "679419", "679420", "679421", "679422", "679423", "679424", "679425", "679426", "679427", "679428", "679429", "679430", "679431", "679432", "679433", "679434", "679435", "679436", "679437", "679438", "679439", "679440", "679441", "679442", "679443", "679444", "679445", "679446", "679447", "679448", "679449", "679450", "679451", "679452", "679453", "679454", "679455", "679456", "679457", "679458", "679459", "679460", "679461", "679462", "679463", "679464", "679465", "679466", "679467", "679468", "679469", "679470", "679471", "679472", "679473", "679474", "679475", "679476", "679477", "679478", "679479", "679480", "679481", "679482", "679483", "679484", "679485", "679486", "679487", "679488", "679489", "679490", "679491", "679492", "679493", "679494", "679495", "679496", "679497", "679498", "679499", "679500", "679501", "679502", "679503", "679504", "679505", "683624", "683625", "683626", "683627", "683628", "683629", "683630", "683631", "683632", "683633", "683634", "683635", "683636", "683637", "683638", "683639", "683640", "683641", "683642", "683643", "683644", "683645", "683646", "683647", "683648", "683649", "683650", "683651", "683652", "683653", "683654", "683655", "683656", "683657", "683658", "683659", "683660", "683661", "683662", "683663", "683664", "683665", "683666", "683667", "683668", "683669", "683670", "683671", "683672", "683673", "683674", "683675", "683676", "683677", "683678", "683679", "683680", "683681", "683682", "683683", "683684", "683685", "683686", "683687", "683688", "683689", "683690", "683691", "683692", "683693", "683694", "683695", "683696", "683697", "683698", "683699", "683700", "683701", "683702", "683703", "683704", "683705", "683706", "683707", "683708", "683709", "683710", "683711", "683712", "683713", "683714", "683715", "683716", "683717", "683718", "683719", "683720", "683721", "683722", "683723", "683724", "683725", "683726", "683727", "683728", "683729", "683730", "683731", "683732", "683733", "683734", "683735", "683736", "683737", "683738", "683739", "683740", "683741", "683742", "683743", "683744", "683745", "683746", "683747", "683748", "683749", "683750", "683751", "683752", "683753", "683754", "683755", "683756", "683757", "683758", "683759", "683760", "683761", "683762", "683763", "683764", "670799");
        System.out.println(jsonObject.size());
        for (Object object : objects) {
            jsonObject.remove(object);
        }
        System.out.println(jsonObject.size());
        System.out.println(jsonObject);
    }

    private List<String> show(List<String> list) {
        return Lists.newArrayList(list.get(0));
    }

    @Test
    public void should_show() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            List<String> show = show(Lists.newArrayList("1", "2", "3"));
            System.out.println(show);
        }
    }

    @Test
    public void ssw() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date parse = simpleDateFormat.parse("2020-04-03 11-11-11");
        System.out.println(parse.getTime());
    }

    @Test
    public void ssw1() throws ParseException {
        Book book = new Book("123", "1234");
        Book book1 = new Book("123", "123411");
        ArrayList<Book> books = Lists.newArrayList(book, book1);
        Map<String, String> collect = books.stream().collect(Collectors.toMap(o -> o.getAuth(), o -> o.getName(), (old, new1) -> new1));
        System.out.println(collect);
    }

    @Test
    public void should_1f1() {
        System.out.println(SeasonEnum.AUTUMN.getSeason());
    }

    @Test
    public void should_Time() throws ParseException {
        String[] parsePatterns = {"yyyy-MM-dd", "yyyy年MM月dd日",
                "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
                "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMdd"};
        String string = "2020-10-10";
        if (string == null) {
            return;
        }
        Date time = DateUtils.parseDate("2020-13-10 ", parsePatterns);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(time));

    }

    @Test
    public void should_dist() {
        List<Book> infoList = new ArrayList<>();
        infoList.add(new Book("11111", "22"));
        infoList.add(new Book("22222", "22"));
        infoList.add(new Book("33333", "23"));
        infoList.add(new Book("11111", "22"));
        infoList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Book::getAuth))), ArrayList::new))
                .forEach(System.out::println);

    }

    @Test
    public void should_checkTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);//设为false即可限定时间格式，抛异常
        Date parse = format.parse("2016-12-30");
//        DateUtils.parseDate("2020-13-10 00:00:00", parsePatterns)
        System.out.println(format.format(parse));
        boolean number = NumberUtils.isNumber("2016-12-30");
        System.out.println(number);
    }

    private static Function<Object, Boolean> checkDateType() {
        return value -> {
            String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"};
            for (String parsePattern : parsePatterns) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parsePattern);
                simpleDateFormat.setLenient(false);
                try {
                    simpleDateFormat.parse(value.toString());
                    return true;
                } catch (ParseException e) {
                }
            }
            return false;
        };
    }

    @Test
    public void should_num() {
        System.out.println(checkDateType().apply("2020-02-02"));
        System.out.println(checkDateType().apply("2020-12-02 22:22"));
    }

    @Test
    public void should_int() {
        int i = 1_23_123;
        System.out.println(i);
        System.out.println(NumberUtils.isDigits("123_123"));

    }

    @Test
    public void should_tomap(){
        Book book = new Book("1","22");
        Book book1= new Book("1","2");
        ArrayList<Book> books = Lists.newArrayList(book, book1);
        books.stream().collect(Collectors.toMap(o->o.getAuth(),o->o.getName()));
    }

    @Test
    public void should_sss(){
        System.out.println(DateUtil.strToDate(""));
    }

    @Test
    public void should_22(){
        HashMap<String, String> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("1","1");
        objectObjectHashMap.put("2","1");
        objectObjectHashMap.put("3","1");
        objectObjectHashMap.put("4","1");
        ssssss(objectObjectHashMap);
        System.out.println(objectObjectHashMap);
    }
    public void ssssss(Map<String,String> map){
        Lists.newArrayList("1","2").forEach(map::remove);
    }

    @Test
    public void should_r2(){
        System.out.println(String.format("page.%s.%s.pageTag", 123, 321));
    }
    @Test
    public void should_8(){
        Child3 child = new Child3();
        try {
            Field field = child.getClass().getDeclaredField("auth");
            child.getClass().getDeclaredField("auth");
            field.setAccessible(true);
            field.set(child, "authvalue");
            Field field1 = Parent3.class.getDeclaredField("name");
            field1.setAccessible(true);
            field1.set(child, "namevalue");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("CustomDataPO getField never go here");
        }
        System.out.println(child);
    }
    @Test
    public void should_88(){
        Child3 child = new Child3();
        try {
            Method auth=child.getClass().getDeclaredMethod("setAuth",String.class);
            auth.setAccessible(true);
            auth.invoke(child,null);

//            Method auth1 = child.getClass().getMethod("setName",String.class);
//            auth1.setAccessible(true);
//            auth1.invoke(child,"authvalue");
        } catch (Exception e) {
            throw new RuntimeException("CustomDataPO getField never go here");
        }
        System.out.println(child);
    }

    @Test
    public void should_11117(){
        ArrayList<String> pageNameList = Lists.newArrayList("GZYT_time_create_random_yH1589296477784", "GZYT_time_detail_random_yH1589296477784", "HBJJ_time_create_random_fX1589295804515", "HBJJ_time_detail_random_fX1589295804515", "HNJS_time_create_random_qE1589296306124", "HNJS_time_detail_random_qE1589296306124", "HNSK_time_create_random_Uk1589296545572", "HNSK_time_detail_random_Uk1589296545572", "HSQJ_time_create_random_Qt1589297121910", "HSQJ_time_detail_random_Qt1589297121910", "HZJC_time_create_random_xP1589297182439", "HZJC_time_detail_random_xP1589297182439", "JRSJ_time_create_random_Pe1589296366645", "JRSJ_time_detail_random_Pe1589296366645", "JXQD_time_create_random_US1589296594310", "JXQD_time_detail_random_US1589296594310", "LZXT_time_create_random_Lf1589296243314", "LZXT_time_detail_random_Lf1589296243314", "MDCM_time_create_random_dR1589296996515", "MDCM_time_detail_random_dR1589296996515", "MZHT_time_create_random_wp1589296888543", "MZHT_time_detail_random_wp1589296888543", "NMYM_time_create_random_ZH1589295878523", "NMYM_time_detail_random_ZH1589295878523", "NMYZ_time_create_random_Ec1589296109985", "NMYZ_time_detail_random_Ec1589296109985", "NXDG_time_create_random_PO1589295993173", "NXDG_time_detail_random_PO1589295993173", "QHQC_time_create_random_Sb1589296051892", "QHQC_time_detail_random_Sb1589296051892", "SZYWQ_time_create_random_Gi1589297308705", "SZYWQ_time_detail_random_Gi1589297308705", "TJZX_time_create_random_Hl1589296833402", "TJZX_time_detail_random_Hl1589296833402", "TTSD_time_create_random_iJ1589295516661", "TTSD_time_detail_random_iJ1589295516661", "TYHH_time_create_random_jC1589296650239", "TYHH_time_detail_random_jC1589296650239", "XAWJ_time_create_random_JE1589295737022", "XAWJ_time_detail_random_JE1589295737022", "XJGS_time_create_random_Rf1589295935289", "XJGS_time_detail_random_Rf1589295935289", "XMKJ_time_create_random_id1589296718821", "XMKJ_time_detail_random_id1589296718821", "XMWZ_time_create_random_Cg1589297243853", "XMWZ_time_detail_random_Cg1589297243853", "YNZZ_time_create_random_IA1589296420869", "YNZZ_time_detail_random_IA1589296420869");
        ArrayList<String> sqlList = Lists.newArrayList("INSERT INTO `tenant_event`\n" +
                "(`sys_name`, `tenant`, `name`, `page_name`, `description`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES ('test', 'CFSH_AGENT', 'CFSH_time_create', 'CFSH_time_create_random_dy1589296167866', '点击是--展示隔离期天数并必填', 2097385, '于金丽', 3853233, '樊弋铭', '2020-05-11 12:46:50', '2020-05-14 06:17:17', 270, 'ENABLED', 'bytedance');\n" +
                "\n" +
                "INSERT INTO `tenant_event_condition`\n" +
                "(`sys_name`, `event_name`, `name`, `scope`, `var_names`, `property_name`, `operator`, `arguments`, `description`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES\n" +
                "('test', 'CFSH_time_create', '', 'fe_entity_data', '', 'isolationStatus', 'eq', 'true', NULL, 2097385, '于金丽', 3853233, '樊弋铭', '2020-05-11 12:46:50', '2020-05-14 06:17:17', 270, 'ENABLED', 'bytedance');\n" +
                "\n" +
                "INSERT INTO `tenant_event_action`\n" +
                "(`sys_name`, `name`, `description`, `event_name`, `page_items`, `property_name`, `function`, `arguments`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES\n" +
                "('test', '', '', 'CFSH_time_create', 'time_create_basicrule_customer_protection_time_isolationDays_random_dy1589296167866', 'required', 'set', 'true', 2097385, '于金丽', 3853233, '樊弋铭', '2020-05-11 12:46:50', '2020-05-14 06:17:17', 270, 'ENABLED', 'bytedance'),\n" +
                "('test', '', '', 'CFSH_time_create', 'time_create_basicrule_customer_protection_time_isolationDays_random_dy1589296167866', 'visible', 'set', 'true', 2097385, '于金丽', 3853233, '樊弋铭', '2020-05-11 12:46:50', '2020-05-14 06:17:17', 270, 'ENABLED', 'bytedance');\n","INSERT INTO `tenant_event`\n" +
                "(`sys_name`, `tenant`, `name`, `page_name`, `description`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES\n" +
                "('test', 'CFSH_AGENT', 'CFSH_time_detai', 'CFSH_time_detail_random_dy1589296167866', '点击是--展示隔离期天数并必填', 2097385, '于金丽', 2097385, '于金丽', '2020-05-11 12:50:15', '2020-05-11 12:54:01', 270, 'ENABLED', 'bytedance');\n" +
                "\n" +
                "INSERT INTO `tenant_event_condition`\n" +
                "(`sys_name`, `event_name`, `name`, `scope`, `var_names`, `property_name`, `operator`, `arguments`, `description`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES\n" +
                "('test', 'CFSH_time_detai', '', 'fe_entity_data', '', 'isolationStatus', 'eq', 'true', NULL, 2097385, '于金丽', 2097385, '于金丽', '2020-05-11 12:50:15', '2020-05-11 12:54:01', 270, 'ENABLED', 'bytedance');\n" +
                "\n" +
                "INSERT INTO `tenant_event_action`\n" +
                "(`sys_name`, `name`, `description`, `event_name`, `page_items`, `property_name`, `function`, `arguments`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES\n" +
                "('test', '', '', 'CFSH_time_detai', 'time_detail_details_baserule_customer_protection_time_isolationDays_random_dy1589296167866', 'required', 'set', 'true', 2097385, '于金丽', 2097385, '于金丽', '2020-05-11 12:50:15', '2020-05-11 12:54:01', 270, 'ENABLED', 'bytedance'),\n" +
                "('test', '', '', 'CFSH_time_detai', 'time_detail_details_baserule_customer_protection_time_isolationDays_random_dy1589296167866', 'visible', 'set', 'true', 2097385, '于金丽', 2097385, '于金丽', '2020-05-11 12:50:15', '2020-05-11 12:54:01', 270, 'ENABLED', 'bytedance');\n","INSERT INTO `tenant_event`\n" +
                "(`sys_name`, `tenant`, `name`, `page_name`, `description`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES\n" +
                "('test', 'ALL', 'CFSH_time_detail_duration', 'CFSH_time_detail_random_dy1589296167866', '点击否-隔离期天数隐藏', 2097385, '于金丽', 2097385, '于金丽', '2020-05-11 12:53:35', '2020-05-11 12:53:35', 270, 'ENABLED', 'bytedance');\n" +
                "\n" +
                "INSERT INTO `tenant_event_condition`\n" +
                "(`sys_name`, `event_name`, `name`, `scope`, `var_names`, `property_name`, `operator`, `arguments`, `description`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES\n" +
                "('test', 'CFSH_time_detail_duration', '', 'fe_entity_data', '', 'isolationStatus', 'eq', 'false', NULL, 2097385, '于金丽', 3853233, '樊弋铭', '2020-05-11 12:46:50', '2020-05-14 06:17:17', 270, 'ENABLED', 'bytedance');\n" +
                "\n" +
                "INSERT INTO `tenant_event_action`\n" +
                "(`sys_name`, `name`, `description`, `event_name`, `page_items`, `property_name`, `function`, `arguments`, `creator_id`, `creator_name`, `modify_id`, `modify_name`, `create_time`, `modify_time`, `version`, `state`, `tenant_code`)\n" +
                "VALUES ('test', '', '', 'CFSH_time_detail_duration', 'time_detail_details_baserule_customer_protection_time_isolationDays_random_dy1589296167866', 'visible', 'set', 'false', 2097385, '于金丽', 2097385, '于金丽', '2020-05-11 12:53:35', '2020-05-11 12:53:35', 270, 'ENABLED', 'bytedance');\n");

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= pageNameList.size(); i++) {
            String pageName = pageNameList.get(i - 1);
            String profile = pageName.substring(0, pageName.indexOf("_"));
            String random = pageName.substring(pageName.lastIndexOf("_")+1);
            if (i%2==1){
                String sql = sqlList.get(0);
                String sql1 = sql.replace("CFSH_time_create_random_dy1589296167866", pageName);
                String sql2 = sql1.replace("CFSH", profile);
                String sql3 = sql2.replace("dy1589296167866", random);
                stringBuffer.append(sql3);
            }else {
                String detailSql = sqlList.get(1);
                String durationSql = sqlList.get(2);

                String sql1 = detailSql.replace("CFSH_time_detail_random_dy1589296167866", pageName);
                String sql2 = sql1.replace("CFSH", profile);
                String sql3 = sql2.replace("dy1589296167866", random);

                stringBuffer.append(sql3);

                String sql11 = durationSql.replace("CFSH_time_detail_random_dy1589296167866", pageName);
                String sql22 = sql11.replace("CFSH", profile);
                String sql33 = sql22.replace("dy1589296167866", random);

                stringBuffer.append(sql33);


            }
        }
        System.out.println(stringBuffer.toString());
    }



@Test
public void should_ssss(){
//    TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
    // 传入时间
//    Date date = new Date();
//    // 获取当前服务器TimeZone
//    String timeZoneId = TimeZone.getDefault().getID();
//    // 抓取城市名称
//    String[] arr = timeZoneId.split("/");
//    String city = arr.length > 1 ? arr[1] : timeZoneId;
//    // 格式化时间
//    String dateStr = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date) + " " + city;
//    System.out.println(dateStr);
//    String s = AccessController.doPrivileged(
//            new GetPropertyAction("user.timezone"));
//    System.out.println(s);
//    System.out.println(LocalDateTime.now(ZoneId.of(s)));
//    String format = LocalDateTime.now(ZoneId.of(s)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//    System.out.println(format);
//    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    System.out.println(new Date().getTime());
    TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
    System.out.println(new Date().getTime());
}













































}
