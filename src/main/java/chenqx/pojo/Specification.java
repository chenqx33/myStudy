package chenqx.pojo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author cqx
 * @date 2018/11/15 14:34
 */
public class Specification {
    private String EI;
    private String productSpecID;
    private String ProductSpecName;
    private String ParentID;
    private String ProductSpecType;
    private String ProductGroupID;
    private String CreatorID;
    private String CreateTime;
    private List<Specification> specData = Lists.newArrayList();
    private List<Specification> specValueData = Lists.newArrayList();

    void process(){
        //key 是 specName value是规格值
        Map<String,List<String>> specNameToSpecValues=Maps.newHashMap();
        //key 是 specName value是规格Id
        Map<String,List<String>> specNameToSpecIds = Maps.newHashMap();

        Map<String,List<String>> specValueIdToSpecId = Maps.newHashMap();
        specData.forEach(o->{

        });
    }


}
