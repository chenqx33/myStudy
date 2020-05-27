package chenqx.mapstruct;

import chenqx.mapstruct.convert.Convert;
import chenqx.mapstruct.pojo.PipelineDTO;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-22 19:18
 **/
public class test {
    public static void main(String[] args) {
        Convert convert = Convert.INSTANCE;
        PipelineDTO pipelineDTO = new PipelineDTO(1L,2L,"codeValue","nameValue",
                "namei18n","code","desc");
        System.out.println(convert.convert(pipelineDTO));
    }
}
