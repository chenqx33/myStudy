import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class NewTest {

    /**
     * String.format中用百分号转义百分号
     */
    @Test
    public void format1() {
        String value = "('id','495463','spu_id','sku_id','spe" +
                "c_id','spec_value_id','order_field','1000',create_time,'1000',last_modified_time,0,'CRM','0123456789','SpuSkuSpecValueRelateObj',1)";
        String spu = "{\n" +
                "  \"b224cc89f5f141bd895cb11fa6bf5e61\": [\n" +
                "    {\n" +
                "      \"760912d4025c4ff9ac50861351619bd4\": \"100g-示范种\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"ca7c0b8a85ab43de9a11028bcd7c55fd\": \"8000粒-综合版\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"3cae4d05712e47bd8256b75ef6b9b863\": [\n" +
                "    {\n" +
                "      \"281627bb7cc64fe190ed4ba370627ae7\": \"综合版-4400粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"9c34b431891f492ab60ce701a7db22f9\": \"示范种-100g\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"86573a136f41411bb74232f5d2396351\": \"8000粒-综合版\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"f066cb43c61b47f6b28cfe6a00f7cb8b\": [\n" +
                "    {\n" +
                "      \"91554d9243ae4a1baeeffedc5a2ac315\": \"综合版-25kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"3452717d635845fc8f5c399362e6df6e\": \"8200粒-综合版\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"5a87f0b30d6d443eae5e5156dc209c58\": [\n" +
                "    {\n" +
                "      \"eefc9473d88f4e5e8fe39472ad12da1c\": \"通用版-50kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"aeb322b2b6e0493dbb9fd46410228e6b\": \"通用版-25kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fe63472100ba4022839fd99ffe3c2f04\": \"综合版-9000粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"9018fc0e2ac84fd28d96a6a8d6af9ceb\": \"综合版-4400粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"675bdae4e7164014b8c9ed726e71c85a\": \"60000粒-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"acc2121b7d5847059ac88ac1fe42cbad\": \"8000粒-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"b1c3e3ac4e0d4cb9853c9b96d0a7cab4\": \"6000粒-综合版\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"30fc3f27c2e9489aa1c074bbd6917720\": [\n" +
                "    {\n" +
                "      \"f5f3b0da1f6245d3a1ed32aba50eb716\": \"综合版-4400粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"a4fb923afd7a4121a3a61d1a509d3b1f\": \"6000粒-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"a2d8491db2c642148077f1ed707ed15a\": \"8000粒-综合版\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"98642b098b91481d9df60159f61893a4\": [\n" +
                "    {\n" +
                "      \"582a10aff8c04596a42f02a7ef46049c\": \"综合版-4400粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"95d99ec1791646a19aa647653b0ade49\": \"综合版-9000粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"893f3f1f5aa24e8ba436b3042fba6cab\": \"通用版-25kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"d71ebc752c754db3933e5a8f7d3b4671\": \"8000粒-综合版\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"bed111f9acc54da583780b600a772cd4\": [\n" +
                "    {\n" +
                "      \"647f08c33e6f418a9376ff2793fe3d34\": \"2kg-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"04860a07e0794de080a84b1cce730133\": \"1kg-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fad04e5e0f1942bb9d342311a1878ad8\": \"大地版-1.9kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"b3392907fab04a34a8c24014d55c92c3\": \"3800粒-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"6b687535c3244cbe9ef81e9957524be3\": \"甘新版-2kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"ef8f9a767b3d451996f2e33cbe170224\": \"综合版-1.5kg\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"136770ecde304eeb841fbf4ff684531f\": [\n" +
                "    {\n" +
                "      \"a2b5f0d2a0ca4945be50dbc0fc988cb9\": \"通用版-50kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"223ee8f721d64a2ba294970bfeaba991\": \"杨凌版-1.75kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"ba77921ff4994fcf9fbaa860a766cdf3\": \"2kg-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fc692e25c58043ee82b2c57d16d88648\": \"4400粒-河南版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"2740927f19284c118f7cede75270f562\": \"4400粒-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"7aa05a4527ed42aeb1437f3b6c62be4e\": \"河南版-2kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"2af12fd31ba14228acc665f7866d7231\": \"1.75kg-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"49754233c9ee4294b08d14cabf9f2e73\": \"宁夏版-5kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"5fdd54a8dacb413e9155eeca588c0552\": \"1kg-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"7e6254b990244788afe40d20be0f9132\": \"5000粒-宁夏版\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"8cffa79e0b4c45ed9987af146e5065c3\": [\n" +
                "    {\n" +
                "      \"daa0bd2eaaab4a65b36d18f3f0450737\": \"综合版-4000粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"d197568fd9b241c298409cea5449888b\": \"1kg-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"62c80af9677544fe83a455fc007c2388\": \"示范种-100g\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"cd54b2c02dc64b6c817e47d22fb9df05\": [\n" +
                "    {\n" +
                "      \"446a09760fd64b21bae4b5f773dc5a79\": \"综合版-1kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"453d640ac36d4f62ba747bd4af988fef\": \"示范种-100g\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"6676bba01ba0462283d94ce8a3a4fa77\": \"4000粒-综合版\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"b4949b7f3dbb426ba4f8d74ee37f3d3d\": [\n" +
                "    {\n" +
                "      \"66353a1115d14aad9a069c41ad49674a\": \"通用版-1kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"ea68c7cb541947028cf62fc7d3271b77\": \"综合版-50kg\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"11f54c91ca0749869d0c018e55806dbe\": [\n" +
                "    {\n" +
                "      \"26a65f1f40754969945f01b21263c2d1\": \"示范种-100g\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"398cf35ce9424146bb9443e2389930e5\": \"贵重版-3000粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"4e1a85e8e96b42839951d8c0fa64838c\": \"4000粒-贵重版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"c37889a876d94c0bb2f7c216b90122a1\": \"贵重版-1kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"a50ab8df84d3424cbfe6f78b977d1dad\": \"3000粒-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"d544e84e8ccf44f282128318f6b85854\": \"4000粒-综合版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"789229f806ac44b6b9df2403d59c36ca\": \"综合版-1kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"4de471b892e64288b9af851b4d038fa5\": \"综合版-3300粒\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"8cee11f385ce4e7cadc2fabc2d33c6ec\": [\n" +
                "    {\n" +
                "      \"1376ff2f63204cd5955ea83d0a783ce4\": \"通用版-2kg*25\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"a4e3b3365e744424b3b72f04bf541efd\": \"通用版-100g\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"825feee3872145ae86240d353b6eda2f\": \"通用版-1kg\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"218c04353db04d26b79902a13ac148f7\": [\n" +
                "    {\n" +
                "      \"b12696954d8b443cb84ef77d658c4429\": \"通用版-1kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"0c0a6380dbcd4ad28ff89971142f20f4\": \"通用版-100g\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"0f63c37207554909b0bab7265acaac47\": [\n" +
                "    {\n" +
                "      \"b0f3b76a37634d1e9ef6640434ef8405\": \"通用版-1kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"828121cecde547ffba89257c5d9ff21a\": \"通用版-100g\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fd3da639b70e47c6ab172f47dc0e3271\": \"通用版-4000粒\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"9c67b775d9d8490cb7261c3b0942d5c5\": [\n" +
                "    {\n" +
                "      \"2444d625bc394c53998afd31930efbba\": \"通用版-1kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"2effcd65199d4beda5b9c8709fe36941\": \"通用版-4200粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"30de4d7caaa84c15b9f4a46d762bb09f\": \"通用版-100g\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"0a4906f7dc97416191176856e2ad9b7f\": [\n" +
                "    {\n" +
                "      \"0088488861bd4f66a6476859be5a20b3\": \"广西云南版-4000粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"c8fdad96e3244981b610b8587980b223\": \"通用版-5kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"77d160b4ef0a40649e9c68e3cfef311e\": \"通用版-1kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"cbd2a34044aa42d5af347fbc631a0e61\": \"通用版-4200粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"5f88bb9c0a094d379bb9c6cdb6cb15b8\": \"通用版-100g\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"92afd350a5d44f5c9d20e58160587ab4\": [\n" +
                "    {\n" +
                "      \"fbebe1e2e0a1475f95293aabe064acef\": \"通用版-3500粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"718a0a94853c43d8aaf192308db5eb3b\": \"广西版-4200粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"2ceeca59a12f4638b8e31b5c7181b82b\": \"通用版-100g\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"33893c6f5fcc4c3aa067635bbe075c5f\": \"通用版-4200粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"7c896a893fc245b3bcbd33cc7a2f4085\": \"通用版-4000粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"88975599b66f42dfb8e31049af3f47c4\": \"通用版-1*30kg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"084f357dcf874ff9908bb6db32303919\": \"通用版-散籽\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"2811465d1d8247d4be71b819a718c58c\": [\n" +
                "    {\n" +
                "      \"af96dc4ac2e54ae8a735e67a89168424\": \"通用版-4000粒*30\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"f46c34e69f3242158c467d103bfc0a25\": \"通用版-100g\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"7168d2707b364291ac5108714446614f\": [\n" +
                "    {\n" +
                "      \"4630de5769634e3da5ecabb3d680ad93\": \"1kg-通用版\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"54801e45cba74c6aa8c57b4db807a669\": \"通用版-4200粒\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"054f664e74364668b7e460aa1bccf9b9\": \"通用版-2kg*15\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String banben = "{\n" +
                "  \"示范种\": \"5c63dc5ceb18acc430dfb4de\",\n" +
                "  \"综合版\": \"807c6b964dbe41f5bb11885f6400e2e4\",\n" +
                "  \"甘新版\": \"5c63dc5ceb18acc430dfb4df\",\n" +
                "  \"宁夏版\": \"5c63dc5ceb18acc430dfb4e1\",\n" +
                "  \"杨凌版\": \"5c63dc5ceb18acc430dfb4e2\",\n" +
                "  \"河南版\": \"5c63dc5ceb18acc430dfb4e3\",\n" +
                "  \"贵重版\": \"5c63dc5ceb18acc430dfb4e4\",\n" +
                "  \"通用版\": \"5c63dc5ceb18acc430dfb4e5\",\n" +
                "  \"广西云南版\":\"5c63dc5ceb18acc430dfb4e6\",\n" +
                "  \"广西版\":\"5c63dc5ceb18acc430dfb4e7\",\n" +
                "  \"大地版\":\"5c63dc5ceb18acc430dfb4e0\"\n" +
                "}";
        String lishu = "{\n" +
                "  \"100g\": \"5c63da88eb18acc430d98cc2\",\n" +
                "  \"8000粒\": \"5c63da88eb18acc430d98cd6\",\n" +
                "  \"4400粒\": \"5c63da88eb18acc430d98cd3\",\n" +
                "  \"25kg\": \"5c63da88eb18acc430d98cc9\",\n" +
                "  \"8200粒\": \"5c63da88eb18acc430d98cd7\",\n" +
                "  \"50kg\": \"5c63da88eb18acc430d98ccc\",\n" +
                "  \"9000粒\": \"5c63da88eb18acc430d98cd8\",\n" +
                "  \"60000粒\": \"5c63da88eb18acc430d98cd9\",\n" +
                "  \"6000粒\":\"5c63da88eb18acc430d98cd5\",\n" +
                "  \"2kg\":\"5c63da88eb18acc430d98cc7\",\n" +
                "  \"1kg\":\"5c63da88eb18acc430d98cc3\",\n" +
                "  \"1.5kg\": \"5c63da88eb18acc430d98cc4\",\n" +
                "  \"1.9kg\": \"5c63da88eb18acc430d98cc6\",\n" +
                "  \"1.75kg\": \"5c63da88eb18acc430d98cc5\",\n" +
                "  \"5000粒\": \"5c63da88eb18acc430d98cd4\",\n" +
                "  \"5kg\": \"5c63da88eb18acc430d98cc8\",\n" +
                "  \"4000粒\": \"5c63da88eb18acc430d98cd1\",\n" +
                "  \"3000粒\": \"5c63da88eb18acc430d98cce\",\n" +
                "  \"3300粒\": \"5c63da88eb18acc430d98ccf\",\n" +
                "  \"散籽\": \"5c63da88eb18acc430d98cdb\",\n" +
                "  \"2kg*25\":\"5c63da88eb18acc430d98ccd\",\n" +
                "  \"4200粒\":\"5c63da88eb18acc430d98cd2\",\n" +
                "  \"3500粒\":\"5c63da88eb18acc430d98cd0\",\n" +
                "  \"1*30kg\": \"5c63da88eb18acc430d98cca\",\n" +
                "  \"4000粒*30\": \"5c63da88eb18acc430d98cda\",\n" +
                "  \"2kg*15\": \"5c63da88eb18acc430d98ccb\",\n" +
                "  \"3800粒\": \"5c64e066742c2fddc310e86a\"\n" +
                "}";

        final JSONObject jsonObject = JSON.parseObject(spu);
        JSONObject jsonObject1 = JSON.parseObject(banben);
        JSONObject jsonObject2 = JSON.parseObject(lishu);
        List<String> values = Lists.newArrayList();
        jsonObject.forEach((k, v) -> {
            for (Object o : (JSONArray) v) {
                JSON.parseObject(o.toString()).forEach((k1, v1) -> {
                    String s = value.replaceAll("spu_id", k);
                    s = s.replaceAll("sku_id", k1);
                    String s1 = s.replaceAll("spec_id", "e6de626c5e974737b4920cdfb25b6f06");
                    s1 = s1.replaceAll("order_field", "1");
                    String s2 = s.replaceAll("spec_id", "5c63da87eb18acc430d98c77");
                    s2 = s2.replaceAll("order_field", "2");
                    for (String s3 : v1.toString().split("-")) {
                        if (jsonObject1.containsKey(s3)) {
                            s1 = s1.replaceAll("spec_value_id", jsonObject1.get(s3).toString());
                        } else {
                            s2 = s2.replaceAll("spec_value_id", jsonObject2.get(s3).toString());
                        }
                    }
                    values.add(s1);
                    values.add(s2);
                });
            }
        });

        String column = "INSERT INTO \"public\".\"spu_sku_spec_value_relate\" (\"id\",\"tenant_id\",\"spu_id\",\"sku_id\",\"spec_id\",\"spec_value_id\",\"order_field\",\"created_by\",\"create_time\",\"last_modified_by\",\"last_modified_time\",\"is_deleted\",\"package\",\"object_describe_id\",\"object_describe_api_name\",\"version\")\n" +
                "VALUES\n";
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : values) {
            stringBuilder.append(column).append(s).append(";").append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void ss(){
        Map<String,String> map = Maps.newHashMap();
        map.put("1","11");
        map.computeIfPresent("1",(k,v)->v.concat("22"));
        System.out.println(map);
    }
}
