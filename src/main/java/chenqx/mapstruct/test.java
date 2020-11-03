package chenqx.mapstruct;

import chenqx.mapstruct.convert.Convert;
import chenqx.mapstruct.pojo.PipelineDTO;

/**
 * @description:
 * @author: chenqixin
 * @create: 2020-05-22 19:18
 **/
public class test {
    public static void main(String[] args) {
//        Convert convert = Convert.INSTANCE;
//        PipelineDTO pipelineDTO = new PipelineDTO(1L,2L,"codeValue","nameValue",
//                null,"code","desc");
//        System.out.println(convert.convert(pipelineDTO));
        System.out.println("{\n" +
                "  \"businessLineId\": \"7226880\",\n" +
                "  \"secret\": \"f07cbdd6ac864cf8b8c76bf62d94e852\"\n" +
                "}");
    }
}
