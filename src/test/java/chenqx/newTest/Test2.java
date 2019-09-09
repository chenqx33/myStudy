package chenqx.newTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.junit.Test;

import java.util.Map;

public class Test2 {
    @Test
    public void ss(){
        JSONObject iconList = JSON.parseObject("{\n" +
                "    \"icon_path\": [\n" +
                "        \"A_201705_11_e4e168dc5ce84c2c84abe7767827bbf0.png\",\n" +
                "        \"A_201705_11_bf65d400b3a94a0087d040bfa4867239.png\",\n" +
                "        \"A_201705_11_b7e610782c374835ad60a6fbbd3d6eda.png\",\n" +
                "        \"A_201705_11_2fd9918d5d384635ab95c03e8c6cae15.png\",\n" +
                "        \"A_201705_11_32c9dd498ecb4896909b38fcda340184.png\",\n" +
                "        \"A_201705_11_a0131af8e55549c68233e12bc53f5a60.png\",\n" +
                "        \"A_201705_11_9fbb2fcb594443c8a5541f7ba16cb6b3.png\",\n" +
                "        \"A_201705_11_176fc57314d947ce9b36b935ae8c6e3a.png\",\n" +
                "        \"A_201705_11_cbede3384e694e11bfd032cf805e98a5.png\",\n" +
                "        \"A_201705_11_d83e1f6e8ec743309f9b7929d860cefd.png\",\n" +
                "        \"A_201705_11_2d89a5aa49d44e82aca3cf952669334b.png\",\n" +
                "        \"A_201705_11_1ad37374db8e41649d08fb16de760a13.png\",\n" +
                "        \"A_201907_02_89752d3f989144ddba0e5669b29a75fe.png\",\n" +
                "        \"A_201907_02_d1413d5827704ada813e4a69391e1c53.png\",\n" +
                "        \"A_201907_02_747ec619067e4b0494e8ca148dfc80d0.png\",\n" +
                "        \"A_201907_02_b5986cfbefa946dd87ffcc0105877422.png\",\n" +
                "        \"A_201907_02_fe8f6e47b0e0484fb0b9e5dbeddb8cc2.png\",\n" +
                "        \"A_201907_02_a483666ca82441c2a09e1c2d5169e419.png\",\n" +
                "        \"A_201907_02_90abd3eb978849aeaff780fb2a221aac.png\",\n" +
                "        \"A_201907_02_fc43b9aace584a63bd6a05548166a014.png\",\n" +
                "        \"A_201907_02_669816b23fcb4d5496ea72aa37eb1ac5.png\",\n" +
                "        \"A_201907_02_42427bac945647f9b6fb0e072af06eb6.png\",\n" +
                "        \"A_201907_02_b998766fcc8e4ff4a87d1b232eb16fd9.png\",\n" +
                "        \"A_201907_02_ae44b66508f74e68855d1484aed26dc6.png\",\n" +
                "        \"A_201907_02_879d0a380aa149f4a0c779746c2c6afc.png\",\n" +
                "        \"A_201907_02_c1ec102c640544a7a6fefd4bcfe9ca67.png\",\n" +
                "        \"A_201907_02_f668961510a14f42bd78dbe1aafc36f9.png\",\n" +
                "        \"A_201907_02_2c51ee8f0ebb4d8a840f438546cd2046.png\",\n" +
                "        \"A_201907_02_3243b49f20014ac78b3eeb9af57fb820.png\",\n" +
                "        \"A_201907_02_6d4bd36224684d7e8c5222015cdfe9fe.png\"\n" +
                "    ],\n" +
                "    \"object_icon\": [\n" +
                "        \"A_201907_02_785afaa9095f46489016dffe68eb8d5d.svg\",\n" +
                "        \"A_201907_02_1e74fb9299524f9fbe52e3a1d42faa47.svg\",\n" +
                "        \"A_201907_02_92600e6ef1204581a3506a0373f0a452.svg\",\n" +
                "        \"A_201907_02_6a487ba9a1334ad5b7ded0259cb54cb1.svg\",\n" +
                "        \"A_201907_02_2277518d6b2a42a4a52798e82192fed9.svg\",\n" +
                "        \"A_201907_02_c41193ac73e0413aa25dc3e6dd1bd2c3.svg\",\n" +
                "        \"A_201907_02_f338abe481ea4da28a286fbfca567504.svg\",\n" +
                "        \"A_201907_02_fb956768902d4c1b95f8092e2ad27206.svg\",\n" +
                "        \"A_201907_02_4d36749852914f17badf73e9a348f63a.svg\",\n" +
                "        \"A_201907_02_513ee6a95a9d4d119d088d4962f036a6.svg\",\n" +
                "        \"A_201907_02_834dc6c54e8b40c9850428ba36f6db35.svg\",\n" +
                "        \"A_201907_02_3d1c16a8f0754fa2bab21548fd9e1f7d.svg\",\n" +
                "        \"A_201907_02_39c66786ba00432a809937393ca1864f.svg\",\n" +
                "        \"A_201907_02_eda73c0cc28c45c3bfb7dd3755b99386.svg\",\n" +
                "        \"A_201907_02_cfb82b7325cf4f4e9cfad00843dc32cc.svg\",\n" +
                "        \"A_201907_02_38d4a9377dc74e0aa9bbd993ca42d2c1.svg\",\n" +
                "        \"A_201907_02_2b8b4c4b30f54f80a31cf704a4521e9e.svg\",\n" +
                "        \"A_201907_02_19ed93de701244d1847c7217f80f28da.svg\",\n" +
                "        \"A_201907_02_abcb4f55bbc846a699b4fc5dd0dd7c91.svg\",\n" +
                "        \"A_201907_02_5d46bcac97904cecac7b60f264da3d46.svg\",\n" +
                "        \"A_201907_02_4df82ef21ff145ec88965440f336efbf.svg\",\n" +
                "        \"A_201907_02_0fd47006f8884aba8f8692a98c8090f6.svg\",\n" +
                "        \"A_201907_02_7de2b8bcca8f4be8a9b7e52aeecdcec1.svg\",\n" +
                "        \"A_201907_02_9c13f0f2298140adb017eabe4023a378.svg\",\n" +
                "        \"A_201907_02_1ced4b462f1f4fd3add848f006c4f968.svg\",\n" +
                "        \"A_201907_02_b8c693353a8d43f4a2e743aa9ae10673.svg\",\n" +
                "        \"A_201907_02_1ed6d197a1274a4eacb8148b15acc2a9.svg\",\n" +
                "        \"A_201907_02_e776a45a26684827942232faad7edb70.svg\",\n" +
                "        \"A_201907_02_e08bad8fba554878a330e4cd93b4ed97.svg\",\n" +
                "        \"A_201907_02_9822117334e149308e2547f18a6eb5cf.svg\"\n" +
                "    ]\n" +
                "}");

        System.out.println("w");
    }


    @Test
    public void s1s(){
        Map<String,String> map = new CaseInsensitiveMap<>();

        map.put(null,"bbB");
        map.put("aAa",null);
        System.out.println(map);
    }
}
