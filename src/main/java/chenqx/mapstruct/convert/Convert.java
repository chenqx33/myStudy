package chenqx.mapstruct.convert;

import chenqx.mapstruct.pojo.PipelineDTO;
import chenqx.mapstruct.pojo.PipelineTDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: chenqixin
 * @create: 2020-05-22 18:01
 **/
@Mapper
public interface Convert {
    Convert INSTANCE = Mappers.getMapper(Convert.class);

    List<PipelineTDTO> convert(List<PipelineDTO> pipelineDTO);
    @Mappings({
            @Mapping(source = "idd", target = "id"),
    })
    PipelineTDTO convert(PipelineDTO pipelineDTO);
}
